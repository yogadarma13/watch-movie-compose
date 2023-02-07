//package com.yogadarma.watchmovie.di
//
//import android.content.Context
//import androidx.room.Room
//import com.yogadarma.core.data.source.local.room.AppDatabase
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object TestDatabaseModule {
//
//    @Singleton
//    @Provides
//    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
//        Room.inMemoryDatabaseBuilder(
//            context,
//            AppDatabase::class.java
//        ).build()
//
//    @Singleton
//    @Provides
//    fun provideMovieDao(appDatabase: AppDatabase) = appDatabase.movieDao()
//}