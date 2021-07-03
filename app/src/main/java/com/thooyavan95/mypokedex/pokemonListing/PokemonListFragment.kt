package com.thooyavan95.mypokedex.pokemonListing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.thooyavan95.mypokedex.R
import com.thooyavan95.mypokedex.model.Pokemon
import com.thooyavan95.mypokedex.pokemonDB.PokemonDataBase
import com.thooyavan95.mypokedex.pokemonListing.adapter.PokemonAdapter
import kotlinx.android.synthetic.main.fragment_pokemon_list.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PokemonListFragment : Fragment(), PokemonAdapter.PokemonSelected {

    private val viewModel by viewModels<PokemonListingViewModel>()
    private lateinit var pokemonAdapter : PokemonAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pokemon_list, container, false)
    }

    override fun onPokemonSelected(pokemon: Pokemon) {

        val action = PokemonListFragmentDirections.actionPokemonListFragmentToPokemonDetailFragment(pokemon.pokemonName, pokemon.pokemonURL)
        findNavController().navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokemonAdapter = PokemonAdapter(this)

        pokemon_recycler_view.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = pokemonAdapter
        }

        lifecycleScope.launch {

           viewModel.pager.collectLatest {
               pokemonAdapter.submitData(it)
           }
        }

        pokemonAdapter.addLoadStateListener { loadstates ->

        }

    }

}