package com.thooyavan95.mypokedex.pokemonDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.thooyavan95.mypokedex.R
import com.thooyavan95.mypokedex.utils.AppConstants
import com.thooyavan95.mypokedex.utils.Utils
import kotlinx.android.synthetic.main.fragment_pokemon_detail.*

class PokemonDetailFragment : Fragment(){

    private val args : PokemonDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokemon_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if(args.pokemonName != null && args.url != null){

            val index = Utils.getIndex(url = args.url!!)
            Utils.getImageLoader().load(AppConstants.IMAGE_BASE_URL + index + AppConstants.IMAGE_EXTENSION)
                .into(detail_image)
            deatil_pokemon_name.text = args.pokemonName
        }

    }

}