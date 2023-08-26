package com.adciasis.recoveryfy.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adciasis.recoveryfy.databinding.ItemNotificationBinding

class NotificationAdapter : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    private var notifications: List<String> = emptyList()

    fun setNotificationList(notifications: List<String>) {
        this.notifications = notifications
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        NotificationViewHolder(
            ItemNotificationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount() = 10//notifications.size

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
       holder.onBind()
    }

    inner class NotificationViewHolder(binding: ItemNotificationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind() {

        }
    }
}