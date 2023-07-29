package com.adciasis.recoveryfy.auth

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.adciasis.recoveryfy.base.BaseViewModel
import com.adciasis.recoveryfy.data.LoginRequest
import com.adciasis.recoveryfy.apis.NetworkState
import com.adciasis.recoveryfy.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
) : BaseViewModel() {

    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, _ -> }

    fun login(loginRequest: LoginRequest) {
        loginUseCase.login(loginRequest).onEach {
            dismissProgress()
            when (it.networkState) {
                NetworkState.Loading -> showProgress()
                NetworkState.Success -> {
                    Log.e("Success", it.data.toString())
                }

                NetworkState.Error -> {
                    Log.e("Error", it.errorResponse?.msg.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

}