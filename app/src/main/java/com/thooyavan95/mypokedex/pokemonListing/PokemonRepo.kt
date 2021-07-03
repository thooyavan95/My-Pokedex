package com.thooyavan95.mypokedex.pokemonListing

import android.util.Log
import com.thooyavan95.mypokedex.model.Pokemon
import com.thooyavan95.mypokedex.model.PokemonList
import com.thooyavan95.mypokedex.model.ResponseStatus
import com.thooyavan95.mypokedex.network.RetrofitInstance
import com.thooyavan95.mypokedex.pokemonDB.PokemonDataBase

class PokemonRepo {

    companion object{
        private const val LIMIT = 20
    }

    suspend fun fetchPokemons(offset : Int, pokemonDataBase: PokemonDataBase) {

        try{
            val response = RetrofitInstance.networkInstance.getPokemonList(LIMIT, offset)
            pokemonDataBase.pokemonDAO.insertPokemons(response)
        }catch (e : Exception){
            Log.d("exception", e.message!!)
        }
    }

}