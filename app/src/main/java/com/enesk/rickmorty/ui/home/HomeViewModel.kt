package com.enesk.rickmorty.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enesk.rickmorty.data.remote.model.Character
import com.enesk.rickmorty.data.remote.model.CharacterResponse
import com.enesk.rickmorty.data.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
): ViewModel() {

    val characterList: MutableLiveData<CharacterResponse> = MutableLiveData()

    fun getData(
        page : Int
    ) = viewModelScope.launch{

        characterList.value = repository.getData(page)
    }

}