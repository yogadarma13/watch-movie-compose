package com.yogadarma.watchmovie.ui.screen.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogadarma.core.domain.model.Movie
import com.yogadarma.core.domain.usecases.CheckFavoriteUseCase
import com.yogadarma.core.domain.usecases.DeleteFavoriteUseCase
import com.yogadarma.core.domain.usecases.InsertFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val insertFavoriteUseCase: InsertFavoriteUseCase,
    private val checkFavoriteUseCase: CheckFavoriteUseCase,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase
) : ViewModel() {

    private val _favorite = mutableStateOf(false)
    val favorite: State<Boolean> get() = _favorite

    fun insertFavorite(movie: Movie) = viewModelScope.launch {
        insertFavoriteUseCase.invoke(movie)
    }

    fun checkFavoriteById(movieId: Int) = viewModelScope.launch {
        _favorite.value = checkFavoriteUseCase.invoke(movieId) >= 1
    }

    fun deleteFavorite(movieId: Int) = viewModelScope.launch {
        deleteFavoriteUseCase.invoke(movieId)
    }

    fun updateFavorite(favorite: Boolean) {
        _favorite.value = favorite
    }
}