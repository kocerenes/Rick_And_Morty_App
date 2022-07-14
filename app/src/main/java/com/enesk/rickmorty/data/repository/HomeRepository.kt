package com.enesk.rickmorty.data.repository

import com.enesk.rickmorty.data.remote.ApiFactory
import com.enesk.rickmorty.data.remote.model.Character
import com.enesk.rickmorty.data.remote.model.CharacterResponse
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val apiFactory: ApiFactory
) {

    suspend fun getData(
        page : Int
    ): CharacterResponse{
        return apiFactory.getAllCharacter(page)
    }

}