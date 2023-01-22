package com.yogadarma.watchmovie.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogadarma.core.data.Resource
import com.yogadarma.core.data.source.remote.model.MovieResponse
import com.yogadarma.core.domain.usecases.GetPopularMovieUseCase
import com.yogadarma.watchmovie.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMovieUseCase: GetPopularMovieUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<MovieResponse>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<MovieResponse>>>
        get() = _uiState

    fun getPopularMovie() {
        viewModelScope.launch {
            getPopularMovieUseCase.invoke().collect { response ->
                when (response) {
                    is Resource.Success -> {
                        _uiState.value = UiState.Success(response.data.orEmpty())
                    }
                    is Resource.Error -> {
                        _uiState.value = UiState.Error(response.message.toString())
                    }
                }
            }
        }
    }
}