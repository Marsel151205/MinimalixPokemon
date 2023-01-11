package com.example.kyrgyzweather.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.kyrgyzweather.databinding.ItemPokemonBinding
import com.example.kyrgyzweather.presentation.base.BaseDiffUtilItemCallback
import com.example.kyrgyzweather.presentation.base.IBaseDiffModel
import com.example.kyrgyzweather.presentation.models.PokemonModelUI

class PokemonAdapter :
    ListAdapter<PokemonModelUI, PokemonAdapter.PokemonViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder =
        PokemonViewHolder(
            ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        getItem(position).let { holder.onBind(it) }
    }

    class PokemonViewHolder(private val binding: ItemPokemonBinding) : ViewHolder(binding.root) {
        fun onBind(pokemonModelUI: PokemonModelUI?) {
            with(binding) {
                tvPokemonName.text = pokemonModelUI?.name.toString()
            }
        }
    }
}