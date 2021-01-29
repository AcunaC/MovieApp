package com.desafio.indra.data.datasource

interface NetworkConnectivityDataSource {

    fun isNetworkAvailable(): Boolean

}