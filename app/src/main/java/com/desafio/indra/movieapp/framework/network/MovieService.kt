package com.desafio.indra.movieapp.framework.network

import com.desafio.indra.movieapp.framework.network.response.MoviePage
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MovieService {

    @GET("discover/movie")
    suspend fun popularMovies(@QueryMap params: Map<String, String>): MoviePage

}