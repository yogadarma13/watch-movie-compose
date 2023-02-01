package com.yogadarma.watchmovie.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogadarma.core.domain.model.Movie
import com.yogadarma.core.domain.usecases.CheckFavoriteUseCase
import com.yogadarma.core.domain.usecases.DeleteFavoriteUseCase
import com.yogadarma.core.domain.usecases.InsertFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val insertFavoriteUseCase: InsertFavoriteUseCase,
    private val checkFavoriteUseCase: CheckFavoriteUseCase,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase
) : ViewModel() {

    private val _favState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val favState: StateFlow<Boolean>
        get() = _favState

    fun insertFavorite(movie: Movie) = viewModelScope.launch {
        insertFavoriteUseCase.invoke(movie)
    }

    fun checkFavoriteById(movieId: Int) = viewModelScope.launch {
        _favState.value = checkFavoriteUseCase.invoke(movieId) >= 1
    }

    fun deleteFavorite(movieId: Int) = viewModelScope.launch {
        deleteFavoriteUseCase.invoke(movieId)
    }
}