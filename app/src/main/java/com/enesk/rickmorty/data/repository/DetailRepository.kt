package com.enesk.rickmorty.data.repository

import com.enesk.rickmorty.data.remote.ApiFactory
import com.enesk.rickmorty.data.remote.DetailRepository
import com.enesk.rickmorty.data.remote.model.character.Character
import com.enesk.rickmorty.data.remote.model.character_detail.CharacterDetailResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class DetailRepository @Inject constructor(
    private val apiFactory: ApiFactory
): DetailRepository {

    override suspend fun getCharacter(id: Int): CharacterDetailResponse {

        return apiFactory.getCharacterById(id)
    }


}