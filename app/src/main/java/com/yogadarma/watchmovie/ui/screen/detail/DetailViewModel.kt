package com.yogadarma.watchmovie.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogadarma.core.domain.model.Movie
import com.yogadarma.core.domain.usecases.InsertFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val insertFavoriteUseCase: InsertFavoriteUseCase) :
    ViewModel() {

    fun insertFavorite(movie: Movie) = viewModelScope.launch {
        insertFavoriteUseCase.invoke(movie)
    }
}