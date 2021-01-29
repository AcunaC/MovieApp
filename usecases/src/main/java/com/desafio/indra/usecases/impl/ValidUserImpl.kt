package com.desafio.indra.usecases.impl

import com.desafio.indra.data.Either
import com.desafio.indra.data.repository.UserAuthenticationRepository
import com.desafio.indra.domain.entity.Failure
import com.desafio.indra.domain.entity.None
import com.desafio.indra.usecases.ValidUser

class ValidUserImpl(private val userAuthenticationRepository: UserAuthenticationRepository) :
    ValidUser() {
    override suspend fun run(params: Request): Either<Failure, None> {
        return userAuthenticationRepository.validLogin(params.username, params.password)
    }
}