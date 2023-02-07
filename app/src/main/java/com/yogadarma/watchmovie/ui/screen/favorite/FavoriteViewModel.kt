package com.yogadarma.watchmovie.ui.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogadarma.core.domain.model.Movie
import com.yogadarma.core.domain.usecases.GetFavoriteUseCase
import com.yogadarma.watchmovie.common.UiState
import com.yogadarma.watchmovie.utils.Dispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavoriteUseCase: GetFavoriteUseCase,
    private val dispatcher: Dispatcher
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<List<Movie>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Movie>>>
        get() = _uiState

    fun getAllFavoriteMovie() = viewModelScope.launch(dispatcher.main) {
        getFavoriteUseCase.invoke().collect {
            _uiState.value = UiState.Success(it)
        }
    }
}