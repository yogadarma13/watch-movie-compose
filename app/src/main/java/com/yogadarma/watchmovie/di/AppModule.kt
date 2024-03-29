package com.yogadarma.watchmovie.di

import com.yogadarma.core.domain.usecases.*
import com.yogadarma.watchmovie.utils.Dispatcher
import com.yogadarma.watchmovie.utils.DispatcherProvider
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
    abstract fun bindsDispatcherProvider(defaultDispatcherProvider: DispatcherProvider): Dispatcher

    @Binds
    @ViewModelScoped
    abstract fun bindsGetPopularMovieUseCase(getPopularMovieImpl: GetPopularMovieImpl): GetPopularMovieUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindsGetFavoriteUseCase(getFavoriteImpl: GetFavoriteImpl): GetFavoriteUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindsInsertFavoriteUseCase(insertFavoriteImpl: InsertFavoriteImpl): InsertFavoriteUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindsCheckFavoriteUseCase(checkFavoriteImpl: CheckFavoriteImpl): CheckFavoriteUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindsDeleteFavoriteUseCase(deleteFavoriteImpl: DeleteFavoriteImpl): DeleteFavoriteUseCase
}