package com.example.kyrgyzweather.domain.usecases

import com.example.kyrgyzweather.domain.repositories.PokemonRepository
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
){

    operator fun invoke() = pokemonRepository.getPokemon()
}