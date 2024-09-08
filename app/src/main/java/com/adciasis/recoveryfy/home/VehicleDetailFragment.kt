package com.adciasis.recoveryfy.home

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.adciasis.recoveryfy.R
import com.adciasis.recoveryfy.base.BaseFragment
import com.adciasis.recoveryfy.databinding.FragmentVehicleDetailBinding
import com.adciasis.recoveryfy.home.adapter.ActionHistoryAdapter

class VehicleDetailFragment : BaseFragment<VehicleDetailViewModel, FragmentVehicleDetailBinding>() {
    private var isVisible: Boolean= false

    override val layout: Int = R.layout.fragment_vehicle_detail
    override val viewModel by lazy {
        ViewModelProvider(this)[VehicleDetailViewModel::class.java]
    }

    override fun initViews() {
        super.initViews()
        binding.actionBar.actionBarTitle.text = resources.getText(R.string.vehicle_summary)
        binding.actionBar.ivBackPress.setOnClickListener {
            onBackPress()
        }
        binding.btnEdit.setOnClickListener {
            EditVehicleDetailFragment::class.java.canonicalName?.let { it1 ->
                launchFragment(EditVehicleDetailFragment(),
                    it1
                )
            }
        }
        binding.tvViewMore.setOnClickListener {
            if (isVisible){
                isVisible= false
                binding.viewMoreLayout.visibility = View.GONE
                binding.tvViewMore.text=resources.getString(R.string.view_more)
            }else{
                isVisible= true
                binding.viewMoreLayout.visibility = View.VISIBLE
                binding.tvViewMore.text=resources.getString(R.string.view_less)
            }
        }

        binding.actionHistoryRV.adapter= ActionHistoryAdapter()
    }
}