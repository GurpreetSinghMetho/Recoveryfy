package com.adciasis.recoveryfy.auth

import com.adciasis.recoveryfy.base.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler

class PasswordResetViewModel :BaseViewModel() {
    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, _ -> }

}