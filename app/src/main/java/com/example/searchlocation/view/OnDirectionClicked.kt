package com.example.searchlocation.view

import com.example.searchlocation.model.entities.Item

interface OnDirectionClicked {
    fun onDirectionClicked(position: Int, item: Item)
}