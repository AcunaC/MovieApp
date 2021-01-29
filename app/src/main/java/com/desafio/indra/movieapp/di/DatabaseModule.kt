package com.desafio.indra.movieapp.di

import android.content.Context
import androidx.room.Room
import com.desafio.indra.movieapp.framework.database.MoviesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideYourDatabase(
        @ApplicationContext appContext: Context
    ) = Room.databaseBuilder(appContext, MoviesDatabase::class.java, "movies_database")
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideMovieDao(database: MoviesDatabase) = database.getMovieDao()

}