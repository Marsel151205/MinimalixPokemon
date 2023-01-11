package com.example.kyrgyzweather.di

import com.example.kyrgyzweather.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()

    @Singleton
    @Provides
    fun providePokemonApiService(retrofitClient: RetrofitClient) =
        retrofitClient.providePokemonApiService()
}