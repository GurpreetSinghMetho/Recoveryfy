package com.adciasis.recoveryfy.home

import androidx.fragment.app.viewModels
import com.adciasis.recoveryfy.R
import com.adciasis.recoveryfy.base.BaseFragment
import com.adciasis.recoveryfy.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel,FragmentHomeBinding>() {

    override val layout: Int = R.layout.fragment_home

    override val viewModel by viewModels<HomeViewModel>()

    override fun initViews() {
        super.initViews()
    }
    override fun onBackPress() {
        requireActivity().finish()
    }

}