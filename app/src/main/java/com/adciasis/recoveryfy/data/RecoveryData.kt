package com.adciasis.recoveryfy.data

import androidx.annotation.DrawableRes

data class RecoveryData(
    @DrawableRes val icon: Int,
    val title: String,
    val desc: String = "(Tasks that are awaiting completion)",
    val count: String,
)