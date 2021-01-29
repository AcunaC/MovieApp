package com.desafio.indra.movieapp.framework.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.desafio.indra.domain.entity.Movie as DomainMovie
import java.util.*

@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val photo: String?,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,
    @ColumnInfo(name = "release_date")
    val releaseDate: Date,
    val overview: String
)

fun Movie.toDomainModel() = DomainMovie(
    id, name, photo, voteAverage, releaseDate, overview
)

fun List<Movie>.toDomainModel() = map { it.toDomainModel() }