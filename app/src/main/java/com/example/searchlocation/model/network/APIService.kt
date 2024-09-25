package com.example.searchlocation.model.network

import com.example.searchlocation.model.entities.AddressResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("v1/autosuggest")
    suspend fun getAddressSuggestions(
        @Query("q") query: String,
        @Query("at") location: String,
        @Query("limit") limit: Int,
        @Query("apiKey") apiKey: String
    ): Response<AddressResponse>
}