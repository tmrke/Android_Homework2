package ru.ageev.android_homework2.service

import android.app.Notification
import android.app.NotificationChannelGroup
import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.IBinder
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import ru.ageev.android_homework2.R
import ru.ageev.android_homework2.domain.CreatePostUseCase
import ru.ageev.android_homework2.domain.GetContentUriUseCase
import javax.inject.Inject

@AndroidEntryPoint
class CreatePostService : Service(), CoroutineScope by MainScope() {

    companion object {

        private const val ARG_TEXT_KEY = "ARG_TEXT_KEY"
        private const val ARG_IMAGES_KEY = "ARG_IMAGES_KEY"
        private const val ACTION_CREATE_POST = "ACTION_CREATE_POST"

        private const val CHANNEL_ID = "Create notification"
        private const val CHANNEL_NAME = "Загрузка данных"

        private const val NOTIFICATION_ID = 777

        fun newIntent(context: Context, text: String?, images: List<Uri?>) =
            Intent(context, CreatePostService::class.java).apply {
                action = ACTION_CREATE_POST
                putExtra(ARG_TEXT_KEY, text)
                putParcelableArrayListExtra(ARG_IMAGES_KEY, ArrayList(images))
            }
    }

    @Inject
    lateinit var getContentUriUseCase: GetContentUriUseCase

    @Inject
    lateinit var createPostUseCase: CreatePostUseCase

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


        intent?.let {
            if (it.action == ACTION_CREATE_POST) {
                startForeground(NOTIFICATION_ID, createNotification())

                val text = it.extras?.getString(ARG_TEXT_KEY)
                val images = it.extras?.getParcelableArrayList<Uri>(ARG_IMAGES_KEY)?.map { uri ->
                    getContentUriUseCase(uri)
                }

                launch {
                    createPostUseCase.execute(text, images?.filterNotNull())
                    stopSelf()
                }
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    private fun createNotification(): Notification {
        createNoteNotificationChannel()

        return NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle(
            getString(R.string.loading_post)
        ).setSmallIcon(R.drawable.ic_explore)
            .setProgress(0, 0, true).build()
    }

    private fun createNoteNotificationChannel() {
        val channel = NotificationChannelCompat.Builder(
            CHANNEL_ID,
            NotificationManagerCompat.IMPORTANCE_LOW
        ).setName(CHANNEL_NAME).build()

        NotificationManagerCompat.from(this).createNotificationChannel(channel)
    }

    override fun onDestroy() {
        cancel()
        super.onDestroy()
    }
}