package com.example.kyrgyzweather.data.repositories

import com.example.kyrgyzweather.data.base.BaseRepository
import com.example.kyrgyzweather.data.dtos.toDomain
import com.example.kyrgyzweather.data.remote.apiservices.PokemonApiService
import com.example.kyrgyzweather.domain.repositories.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val apiService: PokemonApiService
) : BaseRepository(), PokemonRepository {

    override fun getPokemon() = doRequest {
        apiService.fetchPokemon().results.map {
            it.toDomain()
        }
    }
}