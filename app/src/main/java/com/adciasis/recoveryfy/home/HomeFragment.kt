package com.adciasis.recoveryfy.home

import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.adciasis.recoveryfy.R
import com.adciasis.recoveryfy.base.BaseFragment
import com.adciasis.recoveryfy.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override val layout: Int = R.layout.fragment_home

    override val viewModel by activityViewModels<HomeViewModel>()

    override fun initViews() {
        super.initViews()
        launchHome(DashboardFragment())
        with(binding.bottomNavigation) {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.pageProfile ->  launchHome(ProfileFragment())
                    R.id.pageNotification -> launchHome(NotificationFragment())
                    else ->  launchHome(DashboardFragment())
                }
                return@setOnItemSelectedListener true
            }
            showBadgeOnNotification(99)
        }
    }

    private fun showBadgeOnNotification(
        notificationNumber: Int = 0,
        badgeId: Int = R.id.pageNotification,
    ) = with(binding.bottomNavigation) {
        getOrCreateBadge(badgeId).apply {
            backgroundColor = ContextCompat.getColor(requireContext(), R.color.rf_nav_item_red)
            isVisible = notificationNumber > 0
            number = notificationNumber
        }
    }

    private fun launchHome(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentHomeContainer, fragment)
            .commit()
    }

}