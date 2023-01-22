package com.yogadarma.core.data

import com.yogadarma.core.data.source.remote.RemoteDataSource
import com.yogadarma.core.domain.repository.AppRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : AppRepository {
}