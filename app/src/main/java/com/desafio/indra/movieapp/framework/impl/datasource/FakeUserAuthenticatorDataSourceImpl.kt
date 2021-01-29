package com.desafio.indra.movieapp.framework.impl.datasource

import com.desafio.indra.data.Either
import com.desafio.indra.data.Either.Left
import com.desafio.indra.data.Either.Right
import com.desafio.indra.data.datasource.UserAuthenticatorDataSource
import com.desafio.indra.domain.entity.Failure
import com.desafio.indra.domain.entity.None
import com.desafio.indra.movieapp.features.login.LoginFailure.PasswordInvalid
import com.desafio.indra.movieapp.features.login.LoginFailure.UsernameNotFound

class FakeUserAuthenticatorDataSourceImpl : UserAuthenticatorDataSource {

    private companion object {
        const val secretUsername = "Admin"
        const val passwordUsername = "Password*123"
    }

    override suspend fun validLogin(username: String, password: String): Either<Failure, None> {
        return if (username != secretUsername) {
            Left(UsernameNotFound())
        } else {
            if (password != passwordUsername) {
                Left(PasswordInvalid())
            } else {
                Right(None())
            }
        }
    }
}