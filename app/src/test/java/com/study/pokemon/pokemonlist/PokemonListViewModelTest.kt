package com.study.pokemon.pokemonlist

import android.os.Looper
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.study.pokemon.model.PokemonListResponse
import com.study.pokemon.repository.PokemonRepository
import com.study.pokemon.viewmodel.PokemonListViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class PokemonListViewModelTest {
    private lateinit var viewModel : PokemonListViewModel
    private lateinit var pokemonRepo: PokemonRepository

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Shadows.shadowOf(Looper.getMainLooper()).idle()
        pokemonRepo = mock(PokemonRepository::class.java)
        viewModel = PokemonListViewModel(pokemonRepo)
    }

    @Test
    fun searchLiveDataObservesSearchResponse() {

        val pokemonList = PokemonListResponse()
        val observerSearchResponse: Observer<PokemonListResponse> = mock()
        val searchResponseLiveData: MutableLiveData<PokemonListResponse> = viewModel.pokemonList

        searchResponseLiveData.observeForever(observerSearchResponse)
        whenever(viewModel.loadPokemon(20,20)).then {
            searchResponseLiveData.observeForever(observerSearchResponse)
            verify(observerSearchResponse).onChanged(pokemonList)
        }
    }
}