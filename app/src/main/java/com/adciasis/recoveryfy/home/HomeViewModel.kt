package com.adciasis.recoveryfy.home

import com.adciasis.recoveryfy.R
import com.adciasis.recoveryfy.base.BaseViewModel
import com.adciasis.recoveryfy.data.RecoveryData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {

    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, _ -> }

    fun recoverList() = listOf(
        RecoveryData(
            icon = R.drawable.ic_group_release,
            title = "Release",
            count = "5000"
        ),
        RecoveryData(
            icon = R.drawable.ic_group_pending,
            title = "Pending",
            count = "15000"
        ),
        RecoveryData(
            icon = R.drawable.ic_group_holds,
            title = "Holds",
            count = "1000"
        ),
        RecoveryData(
            icon = R.drawable.ic_close,
            title = "Close",
            count = "500"
        )
    )
}