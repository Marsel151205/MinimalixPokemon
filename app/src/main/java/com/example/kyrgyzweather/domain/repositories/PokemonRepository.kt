package com.example.kyrgyzweather.domain.repositories

import com.example.kyrgyzweather.common.either.Either
import com.example.kyrgyzweather.domain.models.PokemonModel
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getPokemon(): Flow<Either<String, List<PokemonModel>>>
}