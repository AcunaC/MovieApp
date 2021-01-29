package com.desafio.indra.movieapp.di

import com.desafio.indra.usecases.GetMovies
import com.desafio.indra.usecases.ValidUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

//@Module
//@InstallIn(ViewModelComponent::class)
//object ViewModelModule {
//
//    @Provides
//    @Singleton
//    fun provideGetMoviesUseCase(getMovies: GetMovies): GetMovies = getMovies
//
//    @Provides
//    @Singleton
//    fun provideValidUserUseCase(validUser: ValidUser): ValidUser = validUser
//
//}