package com.desafio.indra.domain.entity

import java.util.*

data class Movie(
    val id: Int,
    val name: String,
    val photo: String?,
    val voteAverage: Double,
    val releaseDate: Date,
    val overview: String
)
