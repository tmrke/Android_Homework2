package ru.ageev.android_homework2.ui.search_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.ageev.android_homework2.data.model.ProfileCompact
import ru.ageev.android_homework2.domain.profile_use_case.SearchUseCase
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase,
) : ViewModel() {
    private val _searchResultLiveData = MutableLiveData<PagingData<ProfileCompact>>()
    val searchResultLiveData: LiveData<PagingData<ProfileCompact>> = _searchResultLiveData

    fun searchProfile(query: String) {
        viewModelScope.launch {
            searchUseCase.execute(query).cachedIn(viewModelScope).collect { profile ->
                _searchResultLiveData.postValue(profile)
            }
        }
    }
}