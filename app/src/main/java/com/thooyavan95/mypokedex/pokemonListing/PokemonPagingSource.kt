package com.thooyavan95.mypokedex.pokemonListing

import android.app.Application
import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.thooyavan95.mypokedex.model.Pokemon
import com.thooyavan95.mypokedex.pokemonDB.PokemonDataBase

class PokemonPagingSource(val pokemonRepo: PokemonRepo,application : Application) : PagingSource<Int, Pokemon>(){

    private val pokemonDataBase = PokemonDataBase.getInstance(application)

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition?.let{
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {

        val page = params.key ?: 0

        Log.d("page value", page.times(10).toString());
        pokemonRepo.fetchPokemons(page * 10, pokemonDataBase)

         try{
             val loadResult = LoadResult.Page(
                 data = response,
                 prevKey = null,
                 nextKey = page + 2
             )

             Log.d("page result: ", loadResult.data.toString())

             return loadResult

        }catch (e : Exception){
            return LoadResult.Error(throwable = e)
        }

    }
}