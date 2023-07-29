package com.adciasis.recoveryfy.auth

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.adciasis.recoveryfy.R
import com.adciasis.recoveryfy.base.BaseFragment
import com.adciasis.recoveryfy.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment :
    BaseFragment<ForgotPasswordViewModel, FragmentForgotPasswordBinding>() {

    override val layout: Int = R.layout.fragment_forgot_password

    override val viewModel by lazy {
        ViewModelProvider(this)[ForgotPasswordViewModel::class.java]
    }

    override fun initViews() {
        super.initViews()
        binding.actionBar.ivBackPress.setOnClickListener {
            onBackPress()
        }
    }
}