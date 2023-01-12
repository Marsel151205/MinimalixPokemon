package com.example.kyrgyzweather.di

import com.example.data.repositories.PokemonRepositoryImpl
import com.example.domain.repositories.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindPokemonRepository(geoCodingRepositoryImpl: PokemonRepositoryImpl): PokemonRepository
}