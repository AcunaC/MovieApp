package com.desafio.indra.data.datasource


import com.desafio.indra.domain.entity.Movie

interface LocalMovieDataSource {

    suspend fun findMovies(): List<Movie>

    suspend fun saveMovies(movies: List<Movie>)

}