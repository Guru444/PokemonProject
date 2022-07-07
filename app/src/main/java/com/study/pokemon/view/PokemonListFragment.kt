package com.study.pokemon.view

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.provider.Telephony.Mms.Part.TEXT
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.tasks.Task
import com.google.firebase.remoteconfig.BuildConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.study.pokemon.R
import com.study.pokemon.adapter.PokemonListAdapter
import com.study.pokemon.analytics.AnalyticsTools
import com.study.pokemon.databinding.FragmentPokemonListBinding
import com.study.pokemon.model.PokemonListResponse
import com.study.pokemon.util.Constant
import com.study.pokemon.util.checkOverlayPermission
import com.study.pokemon.util.isNetworkAvailable
import com.study.pokemon.viewmodel.PokemonListViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit


@AndroidEntryPoint
class PokemonListFragment : Fragment() {

    private lateinit var binding: FragmentPokemonListBinding
    private val pokemonListViewModel: PokemonListViewModel by viewModels()
    private val pokemonListAdapter = PokemonListAdapter()
    private var paginationState = 0
    private var itemCount = 0
    private lateinit var mRemoteConfig: FirebaseRemoteConfig

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentPokemonListBinding.inflate(layoutInflater)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            checkOverlay()
            firebaseRemoteConfig()

            rvPokemonList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            rvPokemonList.adapter = pokemonListAdapter

            //Pagination
            rvPokemonList.addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (!recyclerView.canScrollVertically(1) && itemCount - paginationState > 0) {
                        paginationState += Constant.PAGINATION_COUNT_POKEMON_LIST
                        loadPokemon()
                    }
                }
            })

            btnTry.setOnClickListener {
                loadPokemon()
            }

            pokemonListViewModel.pokemonList.observe(viewLifecycleOwner) {
                it?.let {
                   it.count?.let { itemCount = it }
                   pokemonListAdapter.setPokemonList(it.results as ArrayList<PokemonListResponse.Result>)
                   pbLoad.visibility = View.GONE
                }
            }

            pokemonListAdapter.pokemonItemClick = {
                it?.let {
                    //Put event pokemonId
                    AnalyticsTools.logCustomEvent(Constant.POKEMON_CLICK, bundleOf(Constant.POKEMON_ID to it))
                    Navigation.findNavController(view).navigate(R.id.action_pokemonListFragment_to_pokemonDetailFragment, bundleOf(Constant.POKEMON_ID to it))
                }
            }

            btnGiveOverlay.setOnClickListener {
                val myIntent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
                startActivity(myIntent)
            }
        }
    }

    private fun loadPokemon(){
        binding.apply {
            if (requireContext().isNetworkAvailable()){
                pbLoad.visibility = View.VISIBLE
                btnTry.visibility = View.GONE
                pokemonListViewModel.loadPokemon(paginationState, 20)
            }else{
                btnTry.visibility = View.VISIBLE
                pbLoad.visibility = View.GONE
                rvPokemonList.visibility = View.GONE
            }
        }
    }

    //DrawOther Permission Check
    private fun checkOverlay(){
        requireContext().checkOverlayPermission{ overlay->
            when(overlay){
                true -> {
                    binding.btnGiveOverlay.visibility = View.VISIBLE
                }
                false -> {
                    binding.btnGiveOverlay.visibility = View.GONE
                    loadPokemon()
                }
            }
        }
    }
    //RemoteConfig Func.
    private fun firebaseRemoteConfig(){
        mRemoteConfig = FirebaseRemoteConfig.getInstance()
        mRemoteConfig.setConfigSettingsAsync(
            FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(0L)
                .build())

        val fetch: Task<Void> = mRemoteConfig.fetch()

        fetch.addOnSuccessListener {
            mRemoteConfig.activate()
            binding.tvTitle.text = mRemoteConfig.getString(TEXT)
        }
    }

    override fun onResume() {
        super.onResume()
        checkOverlay()
        paginationState = 0
        itemCount = 0
    }

}