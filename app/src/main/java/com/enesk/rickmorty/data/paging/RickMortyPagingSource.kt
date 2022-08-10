package com.enesk.rickmorty.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.enesk.rickmorty.data.remote.ApiFactory
import com.enesk.rickmorty.data.remote.model.character.Character
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RickMortyPagingSource @Inject constructor(
    private val apiFactory: ApiFactory
): PagingSource<Int, Character>() {

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val currentPage = params.key ?: 1
            val response = apiFactory.getAllCharacter(currentPage)

            val data = response.body()!!.results ?: emptyList()
            val responseData = mutableListOf<Character>()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage + 1
            )
        }catch (exception : IOException){
            return LoadResult.Error(exception)
        }catch (exception : HttpException){
            return LoadResult.Error(exception)
        }
    }
}