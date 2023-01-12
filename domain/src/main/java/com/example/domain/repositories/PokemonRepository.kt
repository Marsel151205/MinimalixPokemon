package com.example.domain.repositories

import com.example.common.either.Either
import com.example.domain.models.PokemonModel
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getPokemon(): Flow<Either<String, List<PokemonModel>>>
}