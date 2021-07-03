package com.thooyavan95.mypokedex.network

import com.thooyavan95.mypokedex.model.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

@GET("pokemon")
suspend fun getPokemonList(
        @Query ("limit") limit : Int,
        @Query ("offset") offset : Int) : PokemonList

@GET("pokemon/{name}")
suspend fun getPokemon(@Path("name") name : String)

}