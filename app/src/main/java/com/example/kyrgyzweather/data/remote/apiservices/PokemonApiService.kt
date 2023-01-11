package com.example.kyrgyzweather.data.remote.apiservices

import com.example.kyrgyzweather.data.dtos.PokemonDto
import com.example.kyrgyzweather.data.dtos.PokemonResponse
import retrofit2.http.GET

interface PokemonApiService {

    @GET("pokemon")
    suspend fun fetchPokemon(): PokemonResponse<PokemonDto>
}