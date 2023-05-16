package ru.ageev.android_homework2.ui.feed_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.domain.FeedUseCase
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val feedUseCase: FeedUseCase,
) : ViewModel() {
    private val _postsLiveData = MutableLiveData<PagingData<Post>>()
    var postsLiveData = MutableLiveData<PagingData<Post>>()

    fun getFeed() {
        viewModelScope.launch {
            feedUseCase.execute().collect { posts ->
                _postsLiveData.postValue(posts)
            }
        }
    }

}