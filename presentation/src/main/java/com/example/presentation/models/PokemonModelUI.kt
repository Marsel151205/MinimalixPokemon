package com.example.presentation.models

import com.example.domain.models.PokemonModel
import com.example.presentation.base.IBaseDiffModel

data class PokemonModelUI(
    override val name: String
) : IBaseDiffModel<String>

fun PokemonModel.toUI() = PokemonModelUI(
    name = name
)