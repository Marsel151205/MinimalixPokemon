package com.example.kyrgyzweather.data.dtos

import com.example.kyrgyzweather.domain.models.PokemonModel
import com.google.gson.annotations.SerializedName

data class PokemonDto(
    @SerializedName("name")
    val name: String
)

fun PokemonDto.toDomain() = PokemonModel(
    name = name
)