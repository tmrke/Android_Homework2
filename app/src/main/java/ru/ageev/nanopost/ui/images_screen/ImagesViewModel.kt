package ru.ageev.nanopost.ui.images_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.ageev.nanopost.data.model.Image
import ru.ageev.nanopost.domain.image_use_case.GetImagesUseCase
import javax.inject.Inject

@HiltViewModel
class ImagesViewModel @Inject constructor(
    private val imagesUseCase: GetImagesUseCase
) : ViewModel() {
    private val _imagesLiveData = MutableLiveData<PagingData<Image>>()
    val imagesLiveData: LiveData<PagingData<Image>> = _imagesLiveData

    fun getAllImages(profileId: String) {
        viewModelScope.launch {
            imagesUseCase.execute(profileId).collect { images ->
                _imagesLiveData.postValue(images)
            }
        }
    }
}