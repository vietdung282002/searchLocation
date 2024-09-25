package com.example.searchlocation.view

import android.graphics.Typeface
import androidx.recyclerview.widget.RecyclerView
import com.example.searchlocation.databinding.SearchItemBinding
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.searchlocation.model.entities.Item

class SearchAdapter( query: String) :
    ListAdapter<Item,SearchAdapter.SearchViewHolder>(AddressItemDiffUtils()) {

    private var listener: OnDirectionClicked? = null

    class SearchViewHolder(binding: SearchItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val directionBtn = binding.directionBtn
        val tvLocation = binding.tvLocation

    }
    private var queryString = query

    class AddressItemDiffUtils: DiffUtil.ItemCallback<Item>() {


        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }

    override fun submitList(list: List<Item>?) {
        super.submitList(list?.let { ArrayList(it) })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = SearchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val address = getItem(position)
        val spannableString = SpannableString(address.title)
        val queryLowerCase = queryString.lowercase()
        val resultLowerCase = address.title.lowercase()
        var startIndex = resultLowerCase.indexOf(queryLowerCase)

        while (startIndex >= 0) {
            val endIndex = startIndex + queryString.length
            if (endIndex <= address.title.length) {
                spannableString.setSpan(
                    StyleSpan(Typeface.BOLD),
                    startIndex,
                    endIndex,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }

            startIndex = resultLowerCase.indexOf(queryLowerCase, endIndex)

        }
        holder.tvLocation.text = spannableString
        holder.directionBtn.setOnClickListener {
            listener?.onDirectionClicked(position,address)
        }
    }

    fun updateQuery(newQuery: String) {
        queryString = newQuery
    }

    fun setOnDirectionClicked(listener: OnDirectionClicked) {
        this.listener = listener
    }

}
