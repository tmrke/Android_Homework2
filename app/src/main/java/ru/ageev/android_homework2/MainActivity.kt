package ru.ageev.android_homework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import ru.ageev.android_homework2.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //если токен сохранен то в логин
        //возможно будет 2 навграфа
        //сделать свою viewModel и обратиться к prefs для того что бы выбрать свой nav_graph

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}