package com.example.searchlocation

import SearchViewModel
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.example.searchlocation.databinding.ActivityMainBinding
import com.example.searchlocation.model.entities.Item
import com.example.searchlocation.model.network.BaseResponse
import com.example.searchlocation.view.OnDirectionClicked
import com.example.searchlocation.view.SearchAdapter


class MainActivity : AppCompatActivity(), OnDirectionClicked {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var searchAdapter: SearchAdapter
    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        searchAdapter = SearchAdapter("")
        activityMainBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        searchAdapter.setOnDirectionClicked(this)
        activityMainBinding.recyclerView.adapter = searchAdapter

        activityMainBinding.searchTextInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.isNullOrEmpty()){
                    searchAdapter.submitList(emptyList())
                    searchAdapter.updateQuery("")
                }else{
                    val query = s.toString()
                    searchViewModel.onSearchQueryChanged(query.toString())
                    searchAdapter.updateQuery(query.toString())
                    startLoading()
                }
            }
        })

        searchViewModel.searchResults.observe(this){
            when (it) {
                is BaseResponse.Loading -> {
                }

                is BaseResponse.Success -> {
                    stopLoading()
                    searchAdapter.submitList(it.data?.items)
                }

                is BaseResponse.Error -> {
                    stopLoading()
                }

                else -> {

                }
            }
        }
    }

    private fun stopLoading() {
        activityMainBinding.outlinedTextField.startIconDrawable = getDrawable(R.drawable.baseline_search_24)
    }

    private fun startLoading() {
        val drawable = CircularProgressDrawable(this)
        drawable.setStyle(CircularProgressDrawable.DEFAULT);
        drawable.setColorSchemeColors(Color.GREEN);
        activityMainBinding.outlinedTextField.startIconDrawable = drawable
        drawable.start()
    }

    override fun onDirectionClicked(position: Int, item: Item) {
        directionFromCurrentMap(item.position.lat.toString(),item.position.lng.toString())
    }

    private fun directionFromCurrentMap(destinationLatitude: String, destinationLongitude: String) {
        val mapUri = Uri.parse("https://maps.google.com/maps?daddr=$destinationLatitude,$destinationLongitude")
        val intent = Intent(Intent.ACTION_VIEW, mapUri)
        startActivity(intent)
    }
}