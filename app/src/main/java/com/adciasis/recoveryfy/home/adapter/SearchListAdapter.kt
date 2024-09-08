package com.adciasis.recoveryfy.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adciasis.recoveryfy.R
import com.adciasis.recoveryfy.databinding.ItemSearchListBinding

class SearchListAdapter(val selectedPos: (Int) -> Unit) :
    RecyclerView.Adapter<SearchListAdapter.ViewHolder>() {

    private var searchList: List<String> = emptyList()

    fun setSearchListList(searchList: List<String>) {
        this.searchList = searchList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemSearchListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount() = 20//notifications.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.onBind(position)
    }

    inner class ViewHolder(val binding: ItemSearchListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(position: Int) {
            binding.row.setOnClickListener { selectedPos.invoke(position) }
            if (position == 2 || position == 4)
                binding.status.setImageResource(R.drawable.ic_release)
            if (position == 3 || position == 6)
                binding.status.setImageResource(R.drawable.ic_pending)
        }
    }
}