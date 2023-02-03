package com.yogadarma.watchmovie.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogadarma.core.data.Resource
import com.yogadarma.core.domain.model.Movie
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

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    private val _uiState: MutableStateFlow<UiState<List<Movie>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Movie>>>
        get() = _uiState

    private val movies = arrayListOf<Movie>()

    init {
        getPopularMovie()
    }

    private fun getPopularMovie() {
        viewModelScope.launch {
            getPopularMovieUseCase.invoke().collect { response ->
                when (response) {
                    is Resource.Success -> {
                        movies.addAll(response.data.orEmpty())
                        _uiState.value = UiState.Success(response.data.orEmpty())
                    }
                    is Resource.Error -> {
                        _uiState.value = UiState.Error(response.message.toString())
                    }
                }
            }
        }
    }

    fun searchMovie(query: String) {
        _query.value = query
        if (query.isNotBlank()) {
            val result = movies.filter { it.title.contains(query, ignoreCase = true) }
            _uiState.value = UiState.Success(result)
        } else {
            _uiState.value = UiState.Success(movies)
        }
    }
}