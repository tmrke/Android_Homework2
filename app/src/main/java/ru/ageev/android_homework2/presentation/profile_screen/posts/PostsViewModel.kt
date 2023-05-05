package ru.ageev.android_homework2.presentation.profile_screen.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.data.model.Profile
import ru.ageev.android_homework2.domain.GetPostsUseCase
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    private val _postsLiveData = MutableLiveData<PagingData<Post>>()
    val postsLiveData: LiveData<PagingData<Post>> = _postsLiveData

    fun loadPost() {                    //В адапетере, нужно поменять List<Post> на PagingData<Post>
        viewModelScope.launch {
            getPostsUseCase.execute()
                .collect { posts ->       //кэшируем, что бы не подгружать эти значания кадый раз при открытии окна
                    _postsLiveData.postValue(posts)
                }
        }
    }
}