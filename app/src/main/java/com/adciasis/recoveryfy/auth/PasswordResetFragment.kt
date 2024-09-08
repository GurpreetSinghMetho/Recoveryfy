package com.adciasis.recoveryfy.auth

import androidx.lifecycle.ViewModelProvider
import com.adciasis.recoveryfy.R
import com.adciasis.recoveryfy.base.BaseFragment
import com.adciasis.recoveryfy.databinding.FragmentResetPasswordBinding

class PasswordResetFragment : BaseFragment<PasswordResetViewModel, FragmentResetPasswordBinding>() {
    override val layout: Int = R.layout.fragment_reset_password
    override val viewModel by lazy {
        ViewModelProvider(this)[PasswordResetViewModel::class.java]
    }

    override fun initViews() {
        super.initViews()
        binding.actionBar.actionBarTitle.text = resources.getText(R.string.reset_password)
        binding.actionBar.ivBackPress.setOnClickListener {
            onBackPress()
        }
    }
}