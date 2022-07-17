package com.enesk.rickmorty.data.remote

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.enesk.rickmorty.data.remote.model.character.Character
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    fun getCharacters(): Flow<PagingData<Character>>

}