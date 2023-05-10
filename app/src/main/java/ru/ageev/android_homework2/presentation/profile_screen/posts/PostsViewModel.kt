package ru.ageev.android_homework2.presentation.profile_screen.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.domain.GetPostsUseCase
import ru.ageev.android_homework2.presentation.post_screen.PostViewModel
import ru.ageev.android_homework2.presentation.profile_screen.profile.ProfileViewModel
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
) : ViewModel() {
    private val _postsLiveData = MutableLiveData<PagingData<Post>>()
    val postsLiveData: LiveData<PagingData<Post>> = _postsLiveData

    fun loadPosts(profileId: String) {
        viewModelScope.launch {
            getPostsUseCase.execute(profileId)
                .collect { posts ->
                    _postsLiveData.postValue(posts)
                }
        }
    }
}