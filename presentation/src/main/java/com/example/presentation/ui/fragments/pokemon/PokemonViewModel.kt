package com.example.presentation.ui.fragments.pokemon

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase
): ViewModel() {

    fun getPokemon() = getPokemonUseCase()
}