package com.desafio.indra.movieapp.framework.impl.datasource

import com.desafio.indra.data.datasource.LocalMovieDataSource
import com.desafio.indra.domain.entity.Movie
import com.desafio.indra.movieapp.framework.database.dao.MovieDao
import com.desafio.indra.movieapp.framework.database.model.toDomainModel
import com.desafio.indra.movieapp.framework.database.model.Movie as DatabaseMovie

class RoomMovieDataSourceImpl(private val dao: MovieDao) : LocalMovieDataSource {

    override suspend fun findMovies(): List<Movie> {
        return dao.getAllMovies().toDomainModel()
    }

    override suspend fun saveMovies(movies: List<Movie>) {
        dao.updateMovies(movies.toDatabaseModel())
    }

    private fun Movie.toDatabaseModel() = DatabaseMovie(
        id = id,
        name = name,
        photo = photo,
        voteAverage = voteAverage,
        releaseDate = releaseDate,
        overview = overview
    )

    private fun List<Movie>.toDatabaseModel() = map { it.toDatabaseModel() }
}