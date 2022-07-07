package com.study.pokemon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.study.pokemon.R
import com.study.pokemon.model.PokemonListResponse
import com.study.pokemon.util.Constant
import kotlinx.android.synthetic.main.pokemon_item_layout.view.*

class PokemonListAdapter : RecyclerView.Adapter<PokemonListAdapter.ItemViewHolder>() {
    var items: ArrayList<PokemonListResponse.Result> = arrayListOf()
    var pokemonItemClick: (Int?) -> Unit = {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
       ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.pokemon_item_layout, parent, false)
        )

    override fun onBindViewHolder(holder: PokemonListAdapter.ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(result: PokemonListResponse.Result) {
            itemView.pokemon_name.text = result.name
            itemView.setOnClickListener {
                pokemonItemClick(result.url?.substringAfter(Constant.REGEX_URL)?.substringBefore("/")?.toInt())
            }
        }
    }

    fun setPokemonList(pokemonList: ArrayList<PokemonListResponse.Result>){
        items.addAll(pokemonList)
        items.reversed()
        notifyDataSetChanged()
    }
}