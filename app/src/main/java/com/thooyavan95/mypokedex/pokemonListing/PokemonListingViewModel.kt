package com.thooyavan95.mypokedex.pokemonListing

import android.app.Application
import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.thooyavan95.mypokedex.model.PokemonList
import com.thooyavan95.mypokedex.model.ResponseStatus
import com.thooyavan95.mypokedex.model.Pokemon
import com.thooyavan95.mypokedex.model.UIStatus

class PokemonListingViewModel(application: Application) : AndroidViewModel(application){


    val pokemonList : LiveData<UIStatus<List<Pokemon>>>
        get() = mutablePokemonList
    private val mutablePokemonList = MutableLiveData<UIStatus<List<Pokemon>>>()

    val pager = Pager(PagingConfig(pageSize = 20)){
        PokemonPagingSource(PokemonRepo(), application)
    }.flow.cachedIn(viewModelScope)

    init {
        mutablePokemonList.value = UIStatus.Loading
    }

    override fun onPokemonsreceived() {

        when(response){

            is ResponseStatus.Success -> mutablePokemonList.postValue(UIStatus.Content(response.data.pokemonList))

            is ResponseStatus.Error -> UIStatus.Error(response.exception)

        }
    }
}