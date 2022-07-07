package com.study.pokemon.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.google.firebase.FirebaseApp
import com.study.pokemon.R
import com.study.pokemon.databinding.FragmentPokemonDetailBinding
import com.study.pokemon.model.PokemonData
import com.study.pokemon.util.Constant
import com.study.pokemon.util.imgShow
import com.study.pokemon.util.startService
import com.study.pokemon.viewmodel.PokemonDetailViewModel
import com.study.pokemon.viewmodel.PokemonListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetailFragment : Fragment() {

    private lateinit var binding: FragmentPokemonDetailBinding
    private val pokemonDetailViewModel: PokemonDetailViewModel by viewModels()
    private val pokemonData = PokemonData()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPokemonDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            (arguments?.get(Constant.POKEMON_ID) as Int).let {
                pokemonDetailViewModel.pokemonDetail(it)
            }
            pokemonDetailViewModel.pokemonDetail.observe(viewLifecycleOwner) {
                it?.let {
                    requireContext().imgShow(it.sprites?.backDefault, ivPokemon)
                    tvPokemonName.text = it.name
                    tvPokemonHeight.text = it.height.toString()
                    tvPokemonWeight.text = it.weight.toString()
                    pokemonData.apply {
                        name = it.name
                        leftImage = it.sprites?.backDefault
                        rightImage = it.sprites?.frontDefault
                    }
                }
            }
            btnShowOverlay.setOnClickListener {
                requireContext().startService(pokemonData)
            }
        }
    }

}