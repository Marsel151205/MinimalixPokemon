package com.example.data.remote.apiservices

import com.example.data.dtos.PokemonDto
import com.example.data.dtos.PokemonResponse
import retrofit2.http.GET

interface PokemonApiService {

    @GET("pokemon")
    suspend fun fetchPokemon(): PokemonResponse<PokemonDto>
}