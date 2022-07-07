package com.study.pokemon.service

import com.study.pokemon.model.PokemonDetailResponse
import com.study.pokemon.model.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokemonAPI {

    companion object {
        private const val POKEMON_LIST = "pokemon"
        private const val POKEMON_DETAIL = "pokemon/{pokemonId}"

    }

    @GET(POKEMON_LIST)
    suspend fun getPokemonList(@Query("offset") offset: Int, @Query("limit") limit: Int): PokemonListResponse

    @GET(POKEMON_DETAIL)
    suspend fun pokemonDetail(@Path("pokemonId") pokemonId: Int): PokemonDetailResponse

}