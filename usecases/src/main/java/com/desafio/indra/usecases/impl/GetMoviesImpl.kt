package com.desafio.indra.usecases.impl

import com.desafio.indra.data.Either
import com.desafio.indra.data.repository.MovieRepository
import com.desafio.indra.domain.entity.Failure
import com.desafio.indra.domain.entity.Movie
import com.desafio.indra.usecases.GetMovies

class GetMoviesImpl(private val movieRepository: MovieRepository) : GetMovies() {

    override suspend fun run(params: Request): Either<Failure, List<Movie>> =
        movieRepository.fetchMovies(
            pageNumber = params.page
        )
}
