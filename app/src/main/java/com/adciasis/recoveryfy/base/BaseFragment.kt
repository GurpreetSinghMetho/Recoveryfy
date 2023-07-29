package com.adciasis.recoveryfy.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.adciasis.recoveryfy.R
import com.adciasis.recoveryfy.BR
import com.adciasis.recoveryfy.auth.LoginFragment

abstract class BaseFragment<V : BaseViewModel, B : ViewDataBinding> : Fragment() {
    protected lateinit var binding: B

    private val bindingVariable: Int = BR.viewModel

    @get:LayoutRes
    abstract val layout: Int

    abstract val viewModel: V

    private lateinit var progressDialog: Dialog

    override fun onAttach(context: Context) {
        super.onAttach(context)
        backPressDisPatcher()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, layout, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinding()
        initProgressDialog()
        handleProgress()
        initViews()
        observeLiveData()
    }

    private fun backPressDisPatcher() {
        requireActivity().onBackPressedDispatcher.addCallback(this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    onBackPress()
                }
            }
        )
    }

    private fun initBinding() {
        binding.setVariable(bindingVariable, viewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

    private fun initProgressDialog() {
        progressDialog = Dialog(requireContext())
        progressDialog.setContentView(R.layout.progress_dialog)
    }

    protected fun showProgressDialog(isCancelable: Boolean = false) {
        if (!progressDialog.isShowing) {
            progressDialog.setCancelable(isCancelable)
            progressDialog.show()
        }
    }

    protected fun dismissProgressDialog() {
        if (progressDialog.isShowing) {
            progressDialog.dismiss()
        }
    }

    protected fun handleProgress() {
        viewModel.isLoading.observe(viewLifecycleOwner) { progress ->
            if (progress) {
                showProgressDialog()
            } else {
                dismissProgressDialog()
            }
        }
    }

    protected open fun initViews(){}

    protected open fun observeLiveData(){}

    protected fun launchFragment(fragment: Fragment,tagName:String){
        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, fragment)
            .addToBackStack(tagName)
            .commit()
    }

    protected open fun onBackPress() {
        if (requireActivity().supportFragmentManager.backStackEntryCount > 1)
            requireActivity().supportFragmentManager.popBackStack()
    }

}