package com.yogadarma.core.di

import com.yogadarma.core.data.AppRepositoryImpl
import com.yogadarma.core.data.source.local.LocalDataSource
import com.yogadarma.core.data.source.local.LocalDataSourceImpl
import com.yogadarma.core.data.source.remote.RemoteDataSource
import com.yogadarma.core.data.source.remote.RemoteDataSourceImpl
import com.yogadarma.core.domain.repository.AppRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsRepository(appRepositoryImpl: AppRepositoryImpl): AppRepository

    @Binds
    @Singleton
    abstract fun binsRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    @Singleton
    abstract fun bindsLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource
}