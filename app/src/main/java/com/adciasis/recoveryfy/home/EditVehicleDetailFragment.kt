package com.adciasis.recoveryfy.home

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.adciasis.recoveryfy.R
import com.adciasis.recoveryfy.base.BaseFragment
import com.adciasis.recoveryfy.databinding.FragmentEditVehicleSummaryBinding

class EditVehicleDetailFragment :
    BaseFragment<EditVehicleDetailViewModel, FragmentEditVehicleSummaryBinding>() {
    private var isVisible: Boolean = false


    override val layout: Int = R.layout.fragment_edit_vehicle_summary
    override val viewModel by lazy {
        ViewModelProvider(this)[EditVehicleDetailViewModel::class.java]
    }

    override fun initViews() {
        super.initViews()
        binding.actionBar.actionBarTitle.text = resources.getText(R.string.vehicle_summary)
        binding.actionBar.ivBackPress.setOnClickListener {
            onBackPress()
        }
        binding.tvViewMore.setOnClickListener {
            if (isVisible) {
                isVisible = false
                binding.viewMoreLayout.visibility = View.GONE
                binding.tvViewMore.text = resources.getString(R.string.view_more)
            } else {
                isVisible = true
                binding.viewMoreLayout.visibility = View.VISIBLE
                binding.tvViewMore.text = resources.getString(R.string.view_less)
            }
        }

    }
}