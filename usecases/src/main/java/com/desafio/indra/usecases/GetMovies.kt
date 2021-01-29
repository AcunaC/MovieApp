package com.desafio.indra.usecases

import com.desafio.indra.domain.entity.Movie

abstract class GetMovies : UseCase<List<Movie>, GetMovies.Request>() {
    data class Request(val page: Int)
}