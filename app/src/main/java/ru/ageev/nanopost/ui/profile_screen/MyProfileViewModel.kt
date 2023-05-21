package ru.ageev.nanopost.ui.profile_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.ageev.nanopost.data.model.Post
import ru.ageev.nanopost.data.model.Profile
import ru.ageev.nanopost.domain.auth_use_case.DeleteTokenUseCase
import ru.ageev.nanopost.domain.profile_use_case.GetProfileUseCase
import ru.ageev.nanopost.domain.GetUsernameUseCase
import ru.ageev.nanopost.domain.post_use_case.GetPostsUseCase
import ru.ageev.nanopost.domain.profile_use_case.SubscribeUseCase
import ru.ageev.nanopost.domain.profile_use_case.UnsubscribeUseCase
import javax.inject.Inject

@HiltViewModel
class MyProfileViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase,
    private val getUsernameUseCase: GetUsernameUseCase,
    private val deleteTokenUseCase: DeleteTokenUseCase,
    private val subscribeUseCase: SubscribeUseCase,
    private val getPostsUseCase: GetPostsUseCase,
    private val unsubscribeUseCase: UnsubscribeUseCase,
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

    fun unsubscribe(profileId: String) {
        viewModelScope.launch {
            unsubscribeUseCase.execute(profileId)
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
}