package com.enesk.rickmorty.data.repository

import androidx.paging.*
import com.enesk.rickmorty.data.paging.RickMortyPagingSource
import com.enesk.rickmorty.data.remote.ApiFactory
import com.enesk.rickmorty.domain.repository.HomeRepository
import com.enesk.rickmorty.data.remote.model.character.Character
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val apiFactory: ApiFactory
): HomeRepository {

    companion object {
        const val NETWORK_PAGE_SIZE = 10
    }

   //suspend fun getData(
   //    page : Int
   //): CharacterResponse{
   //    return apiFactory.getAllCharacter(page)
   //}

    override fun getCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                maxSize = 200
            ),
            pagingSourceFactory = {RickMortyPagingSource(apiFactory = apiFactory)}
        ).flow


    }

}