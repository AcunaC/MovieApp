package com.desafio.indra.data.repository

import com.desafio.indra.data.Either
import com.desafio.indra.data.datasource.LocalMovieDataSource
import com.desafio.indra.data.datasource.NetworkConnectivityDataSource
import com.desafio.indra.data.datasource.RemoteMovieDataSource
import com.desafio.indra.data.onFailure
import com.desafio.indra.data.onSuccess
import com.desafio.indra.domain.entity.Failure
import com.desafio.indra.domain.entity.Movie

class MovieRepository(
    private val localMovieDataSource: LocalMovieDataSource,
    private val remoteMovieDataSource: RemoteMovieDataSource,
    private val networkConnectivityDataSource: NetworkConnectivityDataSource
) {

    suspend fun fetchMovies(pageNumber: Int = 1): Either<Failure, List<Movie>> =
        when (networkConnectivityDataSource.isNetworkAvailable()) {
            true -> {
                // Obtener las peliculas desde el servidor
                val result = remoteMovieDataSource.findMovies(page = pageNumber)
                // Si hubo un error
                if (result.isLeft) {
                    result.right(localMovieDataSource.findMovies())
                } else {
                    localMovieDataSource.saveMovies(result.getRightValue())
                    result
                }

            }
            false -> Either.rightWithFailure(localMovieDataSource.findMovies())
        }

}