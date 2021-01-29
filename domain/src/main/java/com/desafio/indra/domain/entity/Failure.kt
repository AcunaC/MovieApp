package com.desafio.indra.domain.entity

sealed class Failure {
    object NetworkConnection : Failure()
    object ServerError : Failure()

    /** * Extend this class for [data,usecases] specific failures.*/
    abstract class FeatureFailure: Failure()
}
