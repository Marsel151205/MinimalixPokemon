package com.example.kyrgyzweather.presentation.models

import com.example.kyrgyzweather.domain.models.PokemonModel
import com.example.kyrgyzweather.presentation.base.IBaseDiffModel

data class PokemonModelUI(
    override val name: String
) : IBaseDiffModel<String>

fun PokemonModel.toUI() = PokemonModelUI(
    name = name
)