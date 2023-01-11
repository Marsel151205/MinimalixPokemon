package com.example.kyrgyzweather.presentation.ui.fragments.pokemon

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kyrgyzweather.R
import com.example.kyrgyzweather.common.either.Either
import com.example.kyrgyzweather.databinding.FragmentPokemonBinding
import com.example.kyrgyzweather.presentation.base.BaseFragment
import com.example.kyrgyzweather.presentation.models.toUI
import com.example.kyrgyzweather.presentation.ui.adapters.PokemonAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokemonFragment :
    BaseFragment<FragmentPokemonBinding, PokemonViewModel>(R.layout.fragment_pokemon) {

    override val binding by viewBinding(FragmentPokemonBinding::bind)
    override val viewModel: PokemonViewModel by viewModels()
    private val pokemonAdapter = PokemonAdapter()

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribe() {
        subscribeToPokemon()
    }

    private fun setupRecyclerView() {
        binding.rvPokemon.adapter = pokemonAdapter
    }

    private fun subscribeToPokemon() {
        lifecycleScope.launch {
            viewModel.getPokemon().collect {
                when (it) {
                    is Either.Left -> {
                        Log.e("pokemon", it.message.toString())
                    }
                    is Either.Right -> {
                       val mappingList =  it.data?.map { model ->
                            model.toUI()
                        }
                        pokemonAdapter.submitList(mappingList)
                    }
                }
            }
        }
    }
}