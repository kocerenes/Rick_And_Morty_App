package com.enesk.rickmorty.data.repository

import com.enesk.rickmorty.data.remote.ApiFactory
import com.enesk.rickmorty.domain.repository.DetailRepository
import com.enesk.rickmorty.data.remote.model.character_detail.CharacterDetailResponse
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(
    private val apiFactory: ApiFactory
): DetailRepository {

    override suspend fun getCharacter(id: Int): CharacterDetailResponse {

        return apiFactory.getCharacterById(id)
    }


}