package com.example.data.repositories

import com.example.common.either.Either
import com.example.data.base.BaseRepository
import com.example.data.dtos.toDomain
import com.example.data.remote.apiservices.PokemonApiService
import com.example.domain.models.PokemonModel
import com.example.domain.repositories.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val apiService: PokemonApiService
) : BaseRepository(), PokemonRepository {

    override fun getPokemon(): Flow<Either<String, List<PokemonModel>>> = doRequest {
        apiService.fetchPokemon().results.map {
            it.toDomain()
        }
    }
}