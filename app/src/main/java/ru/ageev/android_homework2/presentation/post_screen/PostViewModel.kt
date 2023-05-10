package ru.ageev.android_homework2.presentation.post_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.domain.GetPostUseCase
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase
) : ViewModel() {

    private val _postsLiveData = MutableLiveData<Post>()
    val postsLiveData: LiveData<Post> = _postsLiveData

    fun getPost(postId: String) {                    //В адапетере, нужно поменять List<Post> на PagingData<Post>
        viewModelScope.launch {
            getPostUseCase.execute(postId).also{posts ->       //кэшируем, что бы не подгружать эти значания кадый раз при открытии окна
                _postsLiveData.postValue(posts)
            }
        }
    }
}