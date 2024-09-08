package com.adciasis.recoveryfy.home

import androidx.fragment.app.activityViewModels
import com.adciasis.recoveryfy.R
import com.adciasis.recoveryfy.base.BaseFragment
import com.adciasis.recoveryfy.databinding.FragmentDashboardBinding
import com.adciasis.recoveryfy.home.adapter.RecoveryDashboardAdapter

class DashboardFragment : BaseFragment<HomeViewModel,FragmentDashboardBinding>() {

    override val layout: Int = R.layout.fragment_dashboard

    override val viewModel by activityViewModels<HomeViewModel>()

    private val recoveryDashboardAdapter by lazy {
        RecoveryDashboardAdapter()
    }

    override fun initViews() {
        super.initViews()
        binding.rvRecovery.apply {
            adapter= recoveryDashboardAdapter
            recoveryDashboardAdapter.setRecoveryList(viewModel.recoverList())
        }
        binding.searchBar.setOnClickListener {
            SearchFragment::class.java.canonicalName?.let { it1 ->
                launchFragment(SearchFragment(),
                    it1
                )
            }
        }
    }

    override fun onBackPress() {
        requireActivity().finish()
    }
}