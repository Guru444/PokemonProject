package com.study.pokemon.repository

import com.study.pokemon.model.PokemonDetailResponse
import com.study.pokemon.model.PokemonListResponse
import com.study.pokemon.service.PokemonAPI
import com.study.pokemon.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository  @Inject constructor(private val api: PokemonAPI){

    suspend fun getPokemonList(offset: Int, limit: Int) : Resource<PokemonListResponse> {
        val response = try {
            api.getPokemonList(offset, limit)
        }catch (e: Exception){
            return Resource.Error(e.message.toString())
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonDetail(pokemonId: Int) : Resource<PokemonDetailResponse>{
        val response = try {
            api.pokemonDetail(pokemonId = pokemonId)
        }catch (e: Exception){
            return Resource.Error(e.message.toString())
        }
        return Resource.Success(response)
    }

}