package com.adciasis.recoveryfy.data

data class LoginRequest(
    val userName: String,
    val password: String,
    val systemInfo: String,
    val latitude: String,
    val longitude: String,
    val appType: String,
)