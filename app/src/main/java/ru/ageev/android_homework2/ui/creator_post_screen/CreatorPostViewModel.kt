package ru.ageev.android_homework2.ui.creator_post_screen

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreatorPostViewModel : ViewModel() {
    private val _createPostLiveData = MutableLiveData<List<Uri>>()
    val createPostLiveData: LiveData<List<Uri>> = _createPostLiveData

    private var imagesUriList: MutableList<Uri> = mutableListOf()

    fun postValueImagesUri(imagesUri: List<Uri>) {
        _createPostLiveData.postValue(imagesUri)
    }

    fun addToListImagesUri(uri: Uri) {

    }

    fun deleteFromListImagesUri(uri: Uri) {

    }
}