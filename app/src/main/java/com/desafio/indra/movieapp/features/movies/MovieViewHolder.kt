package com.desafio.indra.movieapp.features.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.desafio.indra.domain.entity.Movie
import com.desafio.indra.movieapp.databinding.LayoutItemMovieBinding

class MovieViewHolder private constructor(private val binding: LayoutItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie, onMovieClick: (Movie) -> Unit) {
        binding.movie = movie
        binding.cardView.setOnClickListener {
            onMovieClick(movie)
        }
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup) = MovieViewHolder(
            LayoutItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

}