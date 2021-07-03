package com.thooyavan95.mypokedex.pokemonDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.thooyavan95.mypokedex.model.Pokemon

@Database(entities = [Pokemon::class], version = 1, exportSchema = false)
abstract class PokemonDataBase : RoomDatabase() {

companion object{

    @Volatile
    private var INSTANCE : PokemonDataBase? = null

    fun getInstance(context : Context) : PokemonDataBase{

        synchronized(this){

            var instance = INSTANCE

            if(instance == null){
                instance = Room.databaseBuilder(context, PokemonDataBase::class.java, "pokemon")
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
            }

            return instance
        }

    }

}

    abstract val pokemonDAO : PokemonDAO

}