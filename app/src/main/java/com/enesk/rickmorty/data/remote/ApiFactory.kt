package com.enesk.rickmorty.data.remote

import com.enesk.rickmorty.data.remote.model.Character
import com.enesk.rickmorty.data.remote.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiFactory {

    //https://rickandmortyapi.com/api/  -> BASE URL
    // character/?page=2

    @GET("character/")
    suspend fun getAllCharacter(
        @Query("page") page : Int
    ): CharacterResponse

}