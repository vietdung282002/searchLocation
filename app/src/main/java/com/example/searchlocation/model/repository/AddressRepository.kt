package com.example.searchlocation.model.repository

import com.example.searchlocation.model.entities.AddressResponse
import com.example.searchlocation.model.network.API
import retrofit2.Response

class AddressRepository {

        suspend fun searchAddress(query: String,location: String, limit: Int, apiKey: String): Response<AddressResponse> {
            return API.apiService.getAddressSuggestions(query,location,limit, apiKey)
        }

}