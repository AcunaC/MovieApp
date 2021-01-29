package com.desafio.indra.movieapp.framework.impl.datasource

import com.desafio.indra.data.Either
import com.desafio.indra.data.Either.Left
import com.desafio.indra.data.Either.Right
import com.desafio.indra.data.datasource.RemoteMovieDataSource
import com.desafio.indra.domain.entity.Failure
import com.desafio.indra.domain.entity.Failure.NetworkConnection
import com.desafio.indra.domain.entity.Failure.ServerError
import com.desafio.indra.domain.entity.Movie
import com.desafio.indra.movieapp.features.movies.MovieFailure
import com.desafio.indra.movieapp.framework.network.MovieService
import com.desafio.indra.movieapp.framework.network.response.toDomainModel
import com.desafio.indra.movieapp.util.Constants
import retrofit2.HttpException
import java.io.IOException

class RemoteMovieDataSourceImpl(private val movieService: MovieService) : RemoteMovieDataSource {

    override suspend fun findMovies(page: Int): Either<Failure, List<Movie>> {
        try {
            val moviesPage = movieService.popularMovies(
                mapOf(Constants.KEY_PAGE_NUMBER to page.toString())
            )

            return if (moviesPage.results == null) {
                Left(MovieFailure.ListNotAvailable())
            } else {
                Right(moviesPage.toDomainModel())
            }

        } catch (httpException: HttpException) {
            return Left(ServerError)
        } catch (ioException: IOException) {
            return Left(NetworkConnection)
        } catch (ex: Exception) {
            return Left(ServerError)
        }
    }

}
