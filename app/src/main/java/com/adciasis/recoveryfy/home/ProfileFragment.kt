package com.adciasis.recoveryfy.home


import androidx.fragment.app.activityViewModels
import com.adciasis.recoveryfy.R
import com.adciasis.recoveryfy.auth.LoginFragment
import com.adciasis.recoveryfy.base.BaseFragment
import com.adciasis.recoveryfy.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<HomeViewModel, FragmentProfileBinding>() {

    override val layout: Int = R.layout.fragment_profile

    override val viewModel by activityViewModels<HomeViewModel>()

    override fun initViews() {
        super.initViews()
        binding.tvEditProfile.setOnClickListener {
            EditProfileFragment::class.java.canonicalName?.let { it1 ->
                launchFragment(EditProfileFragment(),
                    it1
                )
            }
        }
        binding.btnLogout.setOnClickListener {
            onBackPress()
            LoginFragment::class.java.canonicalName?.let { it1 ->
                launchFragment(
                    LoginFragment(),
                    it1
                )
            }
        }
    }
}