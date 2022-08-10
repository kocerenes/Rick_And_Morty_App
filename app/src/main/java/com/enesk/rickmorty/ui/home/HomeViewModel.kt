package com.enesk.rickmorty.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.enesk.rickmorty.data.remote.ApiFactory
import com.enesk.rickmorty.data.remote.model.character.Character
import com.enesk.rickmorty.data.repository.HomeRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepositoryImpl,
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
