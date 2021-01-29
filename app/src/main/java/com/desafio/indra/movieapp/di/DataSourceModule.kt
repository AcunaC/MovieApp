package com.desafio.indra.movieapp.di

import android.content.Context
import com.desafio.indra.data.datasource.LocalMovieDataSource
import com.desafio.indra.data.datasource.NetworkConnectivityDataSource
import com.desafio.indra.data.datasource.RemoteMovieDataSource
import com.desafio.indra.data.datasource.UserAuthenticatorDataSource
import com.desafio.indra.movieapp.framework.database.dao.MovieDao
import com.desafio.indra.movieapp.framework.impl.datasource.FakeUserAuthenticatorDataSourceImpl
import com.desafio.indra.movieapp.framework.impl.datasource.NetworkConnectivityDataSourceImpl
import com.desafio.indra.movieapp.framework.impl.datasource.RemoteMovieDataSourceImpl
import com.desafio.indra.movieapp.framework.impl.datasource.RoomMovieDataSourceImpl
import com.desafio.indra.movieapp.framework.network.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideLocalMovieDataSource(dao: MovieDao): LocalMovieDataSource {
        return RoomMovieDataSourceImpl(dao)
    }

    @Singleton
    @Provides
    fun provideRemoteMovieDataSource(service: MovieService): RemoteMovieDataSource {
        return RemoteMovieDataSourceImpl(service)
    }

    @Singleton
    @Provides
    fun provideNetworkConnectivityDataSource(@ApplicationContext context: Context): NetworkConnectivityDataSource {
        return NetworkConnectivityDataSourceImpl(context)
    }

    @Singleton
    @Provides
    fun provideUserAuthenticatorDataSource(): UserAuthenticatorDataSource {
        return FakeUserAuthenticatorDataSourceImpl()
    }
}
