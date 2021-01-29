package com.desafio.indra.movieapp.features.movies

import com.desafio.indra.domain.entity.Failure.FeatureFailure

class MovieFailure {
    class ListNotAvailable : FeatureFailure()
    class NonExistentMovie : FeatureFailure()
}

