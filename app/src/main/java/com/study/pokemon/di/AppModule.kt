package com.study.pokemon.di

import com.study.pokemon.repository.PokemonRepository
import com.study.pokemon.service.PokemonAPI
import com.study.pokemon.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun pokemonRepository(api: PokemonAPI) = PokemonRepository(api)

    @Singleton
    @Provides
    fun provideGameApi() : PokemonAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.BASE_URL)
            .build()
            .create(PokemonAPI::class.java)
    }

}