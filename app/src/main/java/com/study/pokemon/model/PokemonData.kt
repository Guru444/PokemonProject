package com.study.pokemon.model

import java.io.Serializable


data class PokemonData(
    var leftImage: String? = null,
    var rightImage: String? = null,
    var name: String? = null
): Serializable
