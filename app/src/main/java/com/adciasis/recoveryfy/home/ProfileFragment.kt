package com.adciasis.recoveryfy.home


import androidx.fragment.app.activityViewModels
import com.adciasis.recoveryfy.R
import com.adciasis.recoveryfy.base.BaseFragment
import com.adciasis.recoveryfy.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<HomeViewModel, FragmentProfileBinding>() {

    override val layout: Int = R.layout.fragment_profile

    override val viewModel by activityViewModels<HomeViewModel>()
}