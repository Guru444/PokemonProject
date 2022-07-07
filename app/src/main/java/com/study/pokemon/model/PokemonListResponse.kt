package com.study.pokemon.model


import com.google.gson.annotations.SerializedName

class PokemonListResponse{
    @SerializedName("count")
    var count: Int? = null
    @SerializedName("next")
    var next: String? = null
    @SerializedName("previous")
    var previous: Any? = null
    @SerializedName("results")
    var results: List<Result>? = null

    data class Result(
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("url")
        var url: String? = null
    )
}