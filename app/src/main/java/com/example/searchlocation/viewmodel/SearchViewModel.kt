package com.example.searchlocation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.searchlocation.model.entities.AddressResponse
import com.example.searchlocation.model.network.BaseResponse
import com.example.searchlocation.model.repository.AddressRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val repository = AddressRepository()

    private val _searchResults = MutableLiveData<BaseResponse<AddressResponse>>()
    val searchResults: LiveData<BaseResponse<AddressResponse>> get() = _searchResults

    private var searchJob: Job? = null

    fun onSearchQueryChanged(query: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(1000)
            if (query.isNotEmpty()) {
                try {
                    Log.d("vietdung282002", "onSearchQueryChanged: ")
                    val results = repository.searchAddress(query,"21.02884,105.85462",20,"O9yjfkwrBMuGNdWtgU3HvT67oMD4X2EbGdXo2gQlj8s")
                    if(results.isSuccessful){
                        _searchResults.value = BaseResponse.Success(results.body())
                    }
                    else{
                        _searchResults.value = BaseResponse.Error(results.message())
                    }
                }catch (e: Exception){
                    _searchResults.value = BaseResponse.Error(e.message)
                }
            }
        }
    }
}