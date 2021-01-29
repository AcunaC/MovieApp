package com.desafio.indra.data.datasource

import com.desafio.indra.data.Either
import com.desafio.indra.domain.entity.Failure
import com.desafio.indra.domain.entity.None

interface UserAuthenticatorDataSource {
    suspend fun validLogin(username: String, password: String): Either<Failure, None>
}