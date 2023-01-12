package com.example.data.dtos

import com.example.domain.models.PokemonModel
import com.google.gson.annotations.SerializedName

data class PokemonDto(
    @SerializedName("name")
    val name: String
)

fun PokemonDto.toDomain() = PokemonModel(
    name = name
)