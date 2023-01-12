package com.example.domain.usecases

import com.example.domain.repositories.PokemonRepository
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
){
    operator fun invoke() = pokemonRepository.getPokemon()
}