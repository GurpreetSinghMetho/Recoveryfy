package com.adciasis.recoveryfy.home

import androidx.lifecycle.ViewModelProvider
import com.adciasis.recoveryfy.R
import com.adciasis.recoveryfy.base.BaseFragment
import com.adciasis.recoveryfy.databinding.FragmentEditProfileBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class EditProfileFragment : BaseFragment<EditProfileViewModel, FragmentEditProfileBinding>() {
    override val layout: Int = R.layout.fragment_edit_profile
    override val viewModel by lazy {
        ViewModelProvider(this)[EditProfileViewModel::class.java]
    }

    override fun initViews() {
        super.initViews()
        binding.actionBar.actionBarTitle.text = resources.getText(R.string.edit_profile)
        binding.actionBar.ivBackPress.setOnClickListener {
            onBackPress()
        }

    }
}