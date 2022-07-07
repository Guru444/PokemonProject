package com.study.pokemon.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.pokemon.model.PokemonListResponse
import com.study.pokemon.repository.PokemonRepository
import com.study.pokemon.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(private val repository: PokemonRepository)  : ViewModel(){

    val pokemonList = MutableLiveData<PokemonListResponse>()
    var errorMessage = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    fun loadPokemon(offset: Int, limit: Int){
        viewModelScope.launch {
            isLoading.value = true
            val result = repository.getPokemonList(offset, limit)
            when(result){
                is Resource.Success -> {
                    pokemonList.value = result.data
                    errorMessage.value = ""
                    isLoading.value = false
                }
                is Resource.Error -> {
                    errorMessage.value = result.message!!
                    isLoading.value = false
                }
                else -> {}
            }
        }
    }
}