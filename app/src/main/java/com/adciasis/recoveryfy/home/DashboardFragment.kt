package com.adciasis.recoveryfy.home

import androidx.fragment.app.activityViewModels
import com.adciasis.recoveryfy.R
import com.adciasis.recoveryfy.base.BaseFragment
import com.adciasis.recoveryfy.databinding.FragmentDashboardBinding

class DashboardFragment : BaseFragment<HomeViewModel,FragmentDashboardBinding>() {
    override val layout: Int = R.layout.fragment_dashboard

    override val viewModel by activityViewModels<HomeViewModel>()
}