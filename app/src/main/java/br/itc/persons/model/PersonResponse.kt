package br.itc.persons.model

import com.google.gson.annotations.SerializedName

data class PersonResponse(
    val page: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total")
    val totalResults: Int?,
    @SerializedName("data")
    val results: List<Person>
)
