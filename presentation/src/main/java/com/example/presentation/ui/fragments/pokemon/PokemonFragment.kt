package com.example.presentation.ui.fragments.pokemon

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.common.either.Either
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentPokemonBinding
import com.example.presentation.models.toUI
import com.example.presentation.ui.adapters.PokemonAdapter
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
                        val mappingList = it.data?.map { model ->
                            model.toUI()
                        }
                        pokemonAdapter.submitList(mappingList)
                    }
                }

            }
        }
    }
}