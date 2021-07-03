package com.thooyavan95.mypokedex.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.thooyavan95.mypokedex.model.Pokemon
import com.thooyavan95.mypokedex.pokemonDB.PokemonDataBase

@ExperimentalPagingApi
class PokemonRemoteMediator(private val pokemonDataBase: PokemonDataBase) : RemoteMediator<Int, Pokemon>() {

    @ExperimentalPagingApi
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, Pokemon>
    ): MediatorResult {



    }
}