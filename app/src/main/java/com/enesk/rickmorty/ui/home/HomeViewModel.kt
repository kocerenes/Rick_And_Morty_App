package com.enesk.rickmorty.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.enesk.rickmorty.data.remote.ApiFactory
import com.enesk.rickmorty.data.remote.model.character.Character
import com.enesk.rickmorty.data.remote.model.character.CharacterResponse
import com.enesk.rickmorty.data.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository,
    private val apiFactory: ApiFactory
): ViewModel() {

    //val characterList: MutableLiveData<CharacterResponse> = MutableLiveData()

    //fun getData(
    //    page : Int
    //) = viewModelScope.launch{
//
    //    characterList.value = repository.getData(page)
    //}

    fun getList(): Flow<PagingData<Character>> {
        return repository.getCharacters().cachedIn(viewModelScope)
    }

    //val userItemsUiStates = repository.getCharacters()
    //    .map { pagingData ->
    //        pagingData.map { userModel -> UserItemUIState(userModel) }
    //    }.cachedIn(viewModelScope)

}
