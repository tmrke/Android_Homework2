package ru.ageev.android_homework2.presentation.profile_screen.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.data.model.Profile
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    //TODO useCase
) : ViewModel() {

    private val _postsLiveData = MutableLiveData<List<Post>>()
    val postsLiveData: LiveData<List<Post>> = _postsLiveData

    fun getPosts() {

    }
}