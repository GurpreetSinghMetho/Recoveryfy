package com.adciasis.recoveryfy.home

import com.adciasis.recoveryfy.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {

    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, _ -> }
}