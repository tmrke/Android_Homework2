package ru.ageev.android_homework2.ui.image_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.ageev.android_homework2.data.model.Image
import ru.ageev.android_homework2.domain.image.DeleteImageUseCase
import ru.ageev.android_homework2.domain.image.GetImageUseCase
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(
    private val getImageUseCase: GetImageUseCase,
    private val deleteImageUseCase: DeleteImageUseCase,
) : ViewModel() {

    private val _imageLiveData = MutableLiveData<Image>()
    val imageLiveData: LiveData<Image> = _imageLiveData

    fun getImage(imageId: String) {
        viewModelScope.launch {
            getImageUseCase.execute(imageId).let { image ->
                _imageLiveData.postValue(image)
            }
        }
    }

    fun deleteImage(imageId: String) {
        viewModelScope.launch {
            deleteImageUseCase.execute(imageId)
        }
    }
}