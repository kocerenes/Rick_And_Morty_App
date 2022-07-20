package com.enesk.rickmorty.data.remote

import com.enesk.rickmorty.data.remote.model.character.Character
import com.enesk.rickmorty.data.remote.model.character_detail.CharacterDetailResponse
import retrofit2.Response

interface DetailRepository {

    suspend fun getCharacter(id : Int) : CharacterDetailResponse

}