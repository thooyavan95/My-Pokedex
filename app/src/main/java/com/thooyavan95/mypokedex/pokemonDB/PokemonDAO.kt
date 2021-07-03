package com.thooyavan95.mypokedex.pokemonDB

import androidx.paging.PagingSource
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thooyavan95.mypokedex.model.Pokemon
import com.thooyavan95.mypokedex.model.PokemonList

interface PokemonDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemons(pokemons : PokemonList)

    @Query("SELECT * FROM pokemon WHERE :query")
    suspend fun getPokemonsFromDB(query : String) : PagingSource<Int, Pokemon>

}