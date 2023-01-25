package com.yogadarma.watchmovie.di

import com.yogadarma.core.domain.usecases.GetFavoriteImpl
import com.yogadarma.core.domain.usecases.GetFavoriteUseCase
import com.yogadarma.core.domain.usecases.GetPopularMovieImpl
import com.yogadarma.core.domain.usecases.GetPopularMovieUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun bindsGetPopularMovieUseCase(getPopularMovieImpl: GetPopularMovieImpl): GetPopularMovieUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindsGetFavoriteUseCase(getFavoriteImpl: GetFavoriteImpl): GetFavoriteUseCase
}