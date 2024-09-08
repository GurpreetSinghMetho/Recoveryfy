package com.adciasis.recoveryfy.auth

import androidx.lifecycle.ViewModelProvider
import com.adciasis.recoveryfy.R
import com.adciasis.recoveryfy.base.BaseFragment
import com.adciasis.recoveryfy.databinding.FragmentOtpVerificationBinding

class OtpVerificationFragment :
    BaseFragment<OtpVerificationViewModel, FragmentOtpVerificationBinding>() {
    override val layout: Int = R.layout.fragment_otp_verification
    override val viewModel by lazy {
        ViewModelProvider(this)[OtpVerificationViewModel::class.java]
    }

    override fun initViews() {
        super.initViews()
        binding.actionBar.actionBarTitle.text = resources.getText(R.string.otp_verification)
        binding.actionBar.ivBackPress.setOnClickListener {
            onBackPress()
        }
        binding.btnSubmit.setOnClickListener {
            PasswordResetFragment::class.java.canonicalName?.let { it1 ->
                launchFragment(
                    PasswordResetFragment(),
                    it1
                )
            }
        }
        binding.tvResend.setOnClickListener {

        }
    }
}