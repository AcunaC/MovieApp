package com.desafio.indra.movieapp.framework.database.dao

import androidx.room.*
import com.desafio.indra.movieapp.framework.database.model.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    suspend fun getAllMovies(): List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<Movie>)

    @Transaction
    suspend fun updateMovies(movies: List<Movie>) {
        insertAll(movies)
    }

}