package com.adciasis.recoveryfy.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adciasis.recoveryfy.apis.ErrorResponse
import com.adciasis.recoveryfy.network.DispatcherProvider
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

abstract class BaseViewModel:ViewModel() {

    private val isLoadingInternal = SingleLiveEvent<Boolean>()
    private val onErrorLiveDataInternal = SingleLiveEvent<ErrorResponse?>()
    val isLoading: LiveData<Boolean>
        get() = isLoadingInternal

    val errorLiveData: LiveData<ErrorResponse?>
        get() = onErrorLiveDataInternal

    abstract val coroutineExceptionHandler: CoroutineExceptionHandler

    protected fun launchCoroutine(block: suspend CoroutineScope.() -> Unit): Job {
        return viewModelScope.launch(coroutineExceptionHandler) {
            block()
        }
    }

    protected fun showProgress() {
        isLoadingInternal.postValue(true)
    }

    protected fun dismissProgress() {
        isLoadingInternal.postValue(false)
    }

    protected fun onError(errorResponse: ErrorResponse?) {
        onErrorLiveDataInternal.postValue(errorResponse)
    }
}