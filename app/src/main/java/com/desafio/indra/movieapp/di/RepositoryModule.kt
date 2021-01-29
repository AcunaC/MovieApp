package com.desafio.indra.movieapp.di

import com.desafio.indra.data.datasource.LocalMovieDataSource
import com.desafio.indra.data.datasource.NetworkConnectivityDataSource
import com.desafio.indra.data.datasource.RemoteMovieDataSource
import com.desafio.indra.data.datasource.UserAuthenticatorDataSource
import com.desafio.indra.data.repository.MovieRepository
import com.desafio.indra.data.repository.UserAuthenticationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        localMovieDataSource: LocalMovieDataSource,
        remoteMovieDataSource: RemoteMovieDataSource,
        networkConnectivityDataSource: NetworkConnectivityDataSource
    ): MovieRepository {
        return MovieRepository(
            localMovieDataSource,
            remoteMovieDataSource,
            networkConnectivityDataSource
        )
    }

    @Provides
    @Singleton
    fun provideUserAuthenticationRepository(userAuthenticatorDataSource: UserAuthenticatorDataSource): UserAuthenticationRepository {
        return UserAuthenticationRepository(userAuthenticatorDataSource)
    }

}