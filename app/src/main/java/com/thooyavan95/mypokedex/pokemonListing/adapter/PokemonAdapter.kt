package com.thooyavan95.mypokedex.pokemonListing.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.thooyavan95.mypokedex.R
import com.thooyavan95.mypokedex.model.Pokemon

class PokemonAdapter(val pokemonSelected: PokemonSelected) : PagingDataAdapter<Pokemon, PokemonViewHolder>(object : DiffUtil.ItemCallback<Pokemon>(){

    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {

        return oldItem.pokemonName == newItem.pokemonName
    }

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {

        return oldItem == newItem
    }
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, null)
        return PokemonViewHolder(view, pokemonSelected)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        getItem(position)?.let { holder.bindViews(it) }
    }

    interface PokemonSelected{
        fun onPokemonSelected(pokemon : Pokemon)
    }

}
