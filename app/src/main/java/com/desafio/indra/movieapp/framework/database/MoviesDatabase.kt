package com.desafio.indra.movieapp.framework.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.desafio.indra.movieapp.framework.database.dao.MovieDao
import com.desafio.indra.movieapp.framework.database.model.Movie


@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DBConverters::class)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun getMovieDao(): MovieDao

//    companion object {
//        @Volatile
//        private var INSTANCE: RHRutasDatabase? = null
//
//        fun getInstance(context: Context): RHRutasDatabase {
//            synchronized(this) {
//                var instance = INSTANCE
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context,
//                        RHRutasDatabase::class.java, "rh_rutas_database"
//                    )
//                        .fallbackToDestructiveMigration()
//                        .build()
//                    INSTANCE = instance
//                }
//                return instance
//            }
//        }
//
//    }
}