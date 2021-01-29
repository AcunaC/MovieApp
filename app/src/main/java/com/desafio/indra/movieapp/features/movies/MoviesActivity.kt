package com.desafio.indra.movieapp.features.movies

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.desafio.indra.domain.entity.Movie
import com.desafio.indra.movieapp.databinding.ActivityMoviesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMoviesBinding
    private lateinit var adapter: MoviesAdapter

    private val viewModel: MoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesBinding.inflate(LayoutInflater.from(this))

        adapter = MoviesAdapter {

        }
        binding.recyclerMovies.adapter = adapter

        viewModel.movies.observe(this, ::handleMovies)

        setContentView(binding.root)
    }

    private fun handleMovies(movies: List<Movie>) {
        adapter.submitList(movies)
        //binding.moviesText.text = movies.joinToString("\n", "Lista de pelis:\n")

    }
}