package ru.ageev.android_homework2.ui.post_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.domain.post_use_case.DeletePostUseCase
import ru.ageev.android_homework2.domain.post_use_case.GetPostUseCase
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase,
    private val deletePostUseCase: DeletePostUseCase
) : ViewModel() {

    private val _postLiveData = MutableLiveData<Post>()
    val postLiveData: LiveData<Post> = _postLiveData

    fun getPost(postId: String) {
        viewModelScope.launch {
            getPostUseCase.execute(postId)
                .also { posts ->
                    _postLiveData.postValue(posts)
                }
        }
    }

    fun deletePost(postId: String) {
        viewModelScope.launch {
            deletePostUseCase.execute(postId)
        }
    }
}