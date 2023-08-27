package com.adciasis.recoveryfy.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adciasis.recoveryfy.data.RecoveryData
import com.adciasis.recoveryfy.databinding.ItemRecoveryItemBinding

class RecoveryDashboardAdapter : RecyclerView.Adapter<RecoveryDashboardAdapter.RecoveryDashboardViewHolder>() {

    private var recoveryList: List<RecoveryData> = emptyList()

    fun setRecoveryList(recoveryList: List<RecoveryData>) {
        this.recoveryList = recoveryList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        RecoveryDashboardViewHolder(
            ItemRecoveryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount() = recoveryList.size

    override fun onBindViewHolder(holder: RecoveryDashboardViewHolder, position: Int) {
        holder.onBind(recoveryList[position])
    }

    inner class RecoveryDashboardViewHolder(private val binding: ItemRecoveryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(recoveryData: RecoveryData) {
            binding.recoveryModel = recoveryData
            binding.ivRecoveryIcon.setImageResource(recoveryData.icon)
        }
    }
}