package com.adciasis.recoveryfy.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adciasis.recoveryfy.databinding.ItemActionHistoryBinding

class ActionHistoryAdapter: RecyclerView.Adapter<ActionHistoryAdapter.ViewHolder>() {

    private var list: List<String> = emptyList()

    fun setActionHistoryList(list: List<String>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        ViewHolder(
            ItemActionHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount() = 10//notifications.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }

    inner class ViewHolder(binding: ItemActionHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind() {

        }
    }
}