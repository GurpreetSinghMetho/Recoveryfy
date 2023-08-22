package com.adciasis.recoveryfy.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.adciasis.recoveryfy.base.BaseViewModel
import com.adciasis.recoveryfy.data.LoginRequest
import com.adciasis.recoveryfy.apis.NetworkState
import com.adciasis.recoveryfy.data.LoginResponse
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

    private val loginResponseInternal: MutableLiveData<LoginResponse?> = MutableLiveData()
    val loginResponseLiveData: LiveData<LoginResponse?>
        get() = loginResponseInternal

    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, _ -> }

    fun login(loginRequest: LoginRequest) {
        loginUseCase.login(loginRequest).onEach {
            dismissProgress()
            when (it.networkState) {
                NetworkState.Loading -> showProgress()
                NetworkState.Success -> {
                    loginResponseInternal.postValue(it.data)
                }

                NetworkState.Error -> {
                    onError(it.errorResponse)
                }
            }
        }.launchIn(viewModelScope)
    }

}