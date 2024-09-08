package com.adciasis.recoveryfy.home

import com.adciasis.recoveryfy.base.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler

class VehicleDetailViewModel:BaseViewModel() {
    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, _ -> }

}