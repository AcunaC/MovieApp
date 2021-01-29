package com.desafio.indra.movieapp.di

import com.desafio.indra.data.repository.MovieRepository
import com.desafio.indra.data.repository.UserAuthenticationRepository
import com.desafio.indra.usecases.GetMovies
import com.desafio.indra.usecases.ValidUser
import com.desafio.indra.usecases.impl.GetMoviesImpl
import com.desafio.indra.usecases.impl.ValidUserImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    @Singleton
    fun provideGetMovies(movieRepository: MovieRepository): GetMovies {
        return GetMoviesImpl(movieRepository)
    }

    @Provides
    @Singleton
    fun provideValidUser(repository: UserAuthenticationRepository): ValidUser {
        return ValidUserImpl(repository)
    }

}