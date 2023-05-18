package ru.ageev.android_homework2.ui.profile_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.ageev.android_homework2.data.model.Post
import ru.ageev.android_homework2.data.model.Profile
import ru.ageev.android_homework2.domain.auth_use_case.DeleteTokenUseCase
import ru.ageev.android_homework2.domain.profile_use_case.GetProfileUseCase
import ru.ageev.android_homework2.domain.GetUsernameUseCase
import ru.ageev.android_homework2.domain.post_use_case.DeletePostUseCase
import ru.ageev.android_homework2.domain.post_use_case.GetPostUseCase
import ru.ageev.android_homework2.domain.post_use_case.GetPostsUseCase
import ru.ageev.android_homework2.domain.profile_use_case.SubscribeUseCase
import javax.inject.Inject

@HiltViewModel
class MyProfileViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase,
    private val getUsernameUseCase: GetUsernameUseCase,
    private val deleteTokenUseCase: DeleteTokenUseCase,
    private val subscribeUseCase: SubscribeUseCase,
    private val getPostsUseCase: GetPostsUseCase,
    private val deletePostUseCase: DeletePostUseCase
) : ViewModel() {

    private val _profileLiveData = MutableLiveData<Profile>()
    val profileLiveData: LiveData<Profile> = _profileLiveData

    fun getProfile(profileId: String) {
        viewModelScope.launch {
            getProfileUseCase.execute(profileId).also { profile ->
                _profileLiveData.postValue(profile)
            }
        }
    }

    fun deleteToken() {
        deleteTokenUseCase.execute()
    }

    fun getUsername(): String {
        return getUsernameUseCase.execute()
    }


    fun subscribe(profileId: String) {
        viewModelScope.launch {
            subscribeUseCase.execute(profileId)
        }
    }

    private val _postsLiveData = MutableLiveData<PagingData<Post>>()
    val postsLiveData: LiveData<PagingData<Post>> = _postsLiveData

    fun loadPosts(profileId: String) {
        viewModelScope.launch {
            getPostsUseCase.execute(profileId).collect { posts ->
                _postsLiveData.postValue(posts)
            }
        }
    }

    fun deletePost(postId: String) {
        viewModelScope.launch {
            deletePostUseCase.execute(postId)
        }
    }
}