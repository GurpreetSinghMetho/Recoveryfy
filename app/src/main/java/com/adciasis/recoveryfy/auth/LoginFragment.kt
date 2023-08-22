package com.adciasis.recoveryfy.auth

import androidx.fragment.app.viewModels
import com.adciasis.recoveryfy.R
import com.adciasis.recoveryfy.base.BaseFragment
import com.adciasis.recoveryfy.data.LoginRequest
import com.adciasis.recoveryfy.databinding.FragmentLoginBinding
import com.adciasis.recoveryfy.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>() {

    override val layout: Int = R.layout.fragment_login

    override val viewModel by viewModels<LoginViewModel>()

    override fun initViews() {
        super.initViews()
        binding.tvForgotPassword.setOnClickListener {
            launchFragment(ForgotPasswordFragment(),ForgotPasswordFragment::class.java.name)
        }
        binding.btnLogin.setOnClickListener {
            viewModel.login(
                LoginRequest(
                    userName = "rakesh412.kumar@gmail.com",
                    password = "admin@123",
                    systemInfo = "",
                    latitude = "0",
                    longitude = "0",
                    appType = "android"
                )
            )
        }
    }

    override fun observeLiveData() {
        super.observeLiveData()
        viewModel.loginResponseLiveData.observe(viewLifecycleOwner){
            launchFragment(HomeFragment(), HomeFragment::class.java.name,true)
        }
    }
}