package ru.ageev.android_homework2.images_screen
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.ageev.android_homework2.databinding.ActivityImagesBinding

class ImagesAdapter : RecyclerView.Adapter<ImagesViewHolderScreen>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolderScreen {
        val binding =
            ActivityImagesBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ImagesViewHolderScreen(binding)
    }

    override fun onBindViewHolder(holder: ImagesViewHolderScreen, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return 1
    }
}