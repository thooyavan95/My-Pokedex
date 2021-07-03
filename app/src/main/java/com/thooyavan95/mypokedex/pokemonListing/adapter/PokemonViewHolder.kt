package com.thooyavan95.mypokedex.pokemonListing.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.thooyavan95.mypokedex.model.Pokemon
import com.thooyavan95.mypokedex.utils.AppConstants
import com.thooyavan95.mypokedex.utils.Utils
import kotlinx.android.synthetic.main.item_pokemon.view.*

class PokemonViewHolder(itemView : View, val pokemonSelected: PokemonAdapter.PokemonSelected) : RecyclerView.ViewHolder(itemView) {

    fun bindViews(pokemon : Pokemon){
        itemView.item_pokemon_name.text = pokemon.pokemonName
        val index = Utils.getIndex(pokemon.pokemonURL)
        Utils.getImageLoader().load(AppConstants.IMAGE_BASE_URL + index + AppConstants.IMAGE_EXTENSION)
            .into(itemView.item_pokemon_image)

        itemView.setOnClickListener {
            if(RecyclerView.NOT_FOCUSABLE != bindingAdapterPosition){
                pokemonSelected.onPokemonSelected(pokemon)
            }
        }
    }

}