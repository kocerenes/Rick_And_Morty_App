package com.enesk.rickmorty.domain.repository

import androidx.paging.PagingData
import com.enesk.rickmorty.data.remote.model.character.Character
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    fun getCharacters(): Flow<PagingData<Character>>

}