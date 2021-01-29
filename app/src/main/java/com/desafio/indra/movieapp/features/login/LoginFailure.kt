package com.desafio.indra.movieapp.features.login

import com.desafio.indra.domain.entity.Failure.FeatureFailure

class LoginFailure {
    class UsernameNotFound : FeatureFailure()
    class PasswordInvalid : FeatureFailure()
}