package com.desafio.indra.movieapp.features.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desafio.indra.domain.entity.Failure
import com.desafio.indra.domain.entity.Movie
import com.desafio.indra.usecases.GetMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val getMovies: GetMovies) : ViewModel() {

    private val TAG = this.javaClass.simpleName

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    init {
        viewModelScope.launch {
            Log.i(TAG, "fetching movies")
            getMovies(GetMovies.Request(1)) { it.fold(::handleFailure, ::handleMovies) }
        }
    }

    private fun handleFailure(failure: Failure) {

    }

    private fun handleMovies(list: List<Movie>) {
        _movies.value = list
    }


}