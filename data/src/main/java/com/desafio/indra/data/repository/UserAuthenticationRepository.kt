package com.desafio.indra.data.repository

import com.desafio.indra.data.Either
import com.desafio.indra.data.datasource.UserAuthenticatorDataSource
import com.desafio.indra.domain.entity.Failure
import com.desafio.indra.domain.entity.None

class UserAuthenticationRepository(
    private val userAuthenticatorDataSource: UserAuthenticatorDataSource
) {

    suspend fun validLogin(
        username: String,
        password: String
    ): Either<Failure, None> {
        return userAuthenticatorDataSource.validLogin(username, password)
    }

}