package ru.ageev.android_homework2

import android.content.Context
import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import ru.ageev.android_homework2.databinding.ActivityPostBinding

class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object{
        fun createIntent(context:Context): Intent {
            return Intent(context, PostActivity::class.java)
        }
    }
}