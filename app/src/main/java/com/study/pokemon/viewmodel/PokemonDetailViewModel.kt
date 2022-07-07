package com.study.pokemon.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.pokemon.model.PokemonDetailResponse
import com.study.pokemon.repository.PokemonRepository
import com.study.pokemon.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(private val repository: PokemonRepository) : ViewModel(){

    val pokemonDetail = MutableLiveData<PokemonDetailResponse?>()
    var errorMessage = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    fun pokemonDetail(pokemonId: Int) {
        viewModelScope.launch {
            isLoading.value = true
            val result = repository.getPokemonDetail(pokemonId = pokemonId)
            when(result){
                is Resource.Success -> {
                    pokemonDetail.value = result.data
                    errorMessage.value = ""
                    isLoading.value = false
                }
                is Resource.Error -> {
                    errorMessage.value = result.message!!
                    isLoading.value = false
                }
                else ->{
                    errorMessage.value = result.message!!
                }
            }
        }
    }
}