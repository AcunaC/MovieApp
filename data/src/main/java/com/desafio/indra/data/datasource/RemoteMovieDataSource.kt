package com.desafio.indra.data.datasource

import com.desafio.indra.data.Either
import com.desafio.indra.domain.entity.Failure
import com.desafio.indra.domain.entity.Movie

interface RemoteMovieDataSource {

    suspend fun findMovies(page: Int): Either<Failure, List<Movie>>

}