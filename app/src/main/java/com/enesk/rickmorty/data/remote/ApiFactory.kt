package com.enesk.rickmorty.data.remote

import com.enesk.rickmorty.data.remote.model.character.Character
import com.enesk.rickmorty.data.remote.model.character.CharacterResponse
import com.enesk.rickmorty.data.remote.model.character_detail.CharacterDetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiFactory {

    //https://rickandmortyapi.com/api/  -> BASE URL
    // character/?page=2

    @GET("character/")
    suspend fun getAllCharacter(
        @Query("page") page : Int
    ): Response<CharacterResponse>

    @GET("character/{id}")
     suspend fun getCharacterById(
        @Path("id") id : Int
    ): CharacterDetailResponse

}