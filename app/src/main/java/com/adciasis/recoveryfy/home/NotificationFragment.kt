package com.adciasis.recoveryfy.home


import androidx.fragment.app.activityViewModels
import com.adciasis.recoveryfy.R
import com.adciasis.recoveryfy.base.BaseFragment
import com.adciasis.recoveryfy.databinding.FragmentNotificationBinding

class NotificationFragment : BaseFragment<HomeViewModel,FragmentNotificationBinding>() {

    override val layout: Int= R.layout.fragment_notification
    override val viewModel by activityViewModels<HomeViewModel>()
}