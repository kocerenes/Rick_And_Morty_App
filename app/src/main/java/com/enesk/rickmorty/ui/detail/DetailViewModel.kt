package com.enesk.rickmorty.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enesk.rickmorty.data.remote.model.character.Character
import com.enesk.rickmorty.data.remote.model.character_detail.CharacterDetailResponse
import com.enesk.rickmorty.data.repository.DetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: DetailRepository
): ViewModel() {

    val detailResponse: MutableLiveData<CharacterDetailResponse?> = MutableLiveData()

    fun getCharacter(id : Int) = viewModelScope.launch{
        val request = repository.getCharacter(id)
        detailResponse.value = request
    }

}