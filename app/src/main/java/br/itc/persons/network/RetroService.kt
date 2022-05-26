package br.itc.persons.network

import br.itc.persons.model.PersonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("users")
    suspend fun getDataFromApi(@Query("page") page: Int): PersonResponse
}