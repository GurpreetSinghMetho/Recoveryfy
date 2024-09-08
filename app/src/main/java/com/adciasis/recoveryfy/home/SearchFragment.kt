package com.adciasis.recoveryfy.home

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.adciasis.recoveryfy.R
import com.adciasis.recoveryfy.base.BaseFragment
import com.adciasis.recoveryfy.databinding.FragmentSearchBinding
import com.adciasis.recoveryfy.home.adapter.SearchListAdapter

class SearchFragment : BaseFragment<SearchViewModel, FragmentSearchBinding>() {

    override val layout: Int = R.layout.fragment_search
    override val viewModel by lazy {
        ViewModelProvider(this)[SearchViewModel::class.java]
    }

    override fun initViews() {
        super.initViews()
        binding.back.setOnClickListener { onBackPress() }
        binding.filter.setOnClickListener {
            binding.filterBottomSheet.container.visibility = View.VISIBLE
        }
        binding.filterBottomSheet.indicator.setOnClickListener {
            binding.filterBottomSheet.container.visibility = View.GONE
        }
        binding.filterBottomSheet.btnReset.setOnClickListener {
            binding.filterBottomSheet.container.visibility = View.GONE
        }
        binding.filterBottomSheet.btnApply.setOnClickListener {
            binding.filterBottomSheet.container.visibility = View.GONE
        }
        binding.searchRecyclerview.adapter = SearchListAdapter(selectedPos = {
            VehicleDetailFragment::class.java.canonicalName?.let { it1 ->
                launchFragment(
                    VehicleDetailFragment(), it1
                )
            }
        })
    }
}