package com.thooyavan95.mypokedex.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class PokemonList(
    @SerializedName("results")
    val pokemonList : List<Pokemon>)

@Entity(tableName = "pokemon")
data class Pokemon(
    @PrimaryKey
    @SerializedName("name")
    val pokemonName : String,
    @SerializedName("url")
    val pokemonURL : String)