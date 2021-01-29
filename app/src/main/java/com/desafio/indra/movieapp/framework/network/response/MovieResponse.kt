package com.desafio.indra.movieapp.framework.network.response

import com.desafio.indra.domain.entity.Movie
import com.desafio.indra.movieapp.util.parseDate
import com.google.gson.annotations.SerializedName


data class MovieResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("original_title") val name: String,
    @SerializedName("poster_path") val photo: String,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("overview") val overview: String
)


data class MoviePage(
    @SerializedName("page") val page: Int? = 0,
    @SerializedName("total_pages") val totalPages: Int? = 0,
    @SerializedName("total_results") val totalResult: Int? = 0,
    @SerializedName("results") val results: List<MovieResponse>? = emptyList()
)



fun MovieResponse.toDomainModel() = Movie(
    id,
    name,
    photo,
    voteAverage,
    releaseDate.parseDate(),
    overview
)

fun MoviePage.toDomainModel() = results!!.map { it.toDomainModel() }