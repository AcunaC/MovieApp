package com.desafio.indra.usecases

import com.desafio.indra.domain.entity.None
import com.desafio.indra.usecases.ValidUser.Request

abstract class ValidUser : UseCase<None, Request>() {
    data class Request(
        val username: String,
        val password: String
    )
}