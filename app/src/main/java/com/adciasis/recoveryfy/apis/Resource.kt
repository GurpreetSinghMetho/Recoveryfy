package com.adciasis.recoveryfy.apis

data class Resource<T>(
    val data: T? = null,
    val errorResponse: ErrorResponse? = null,
    val networkState: NetworkState = NetworkState.Loading,
)

data class ErrorResponse(
    val status: Int = 0,
    val msg: String? = null,
)

enum class NetworkState {
    Success,
    Error,
    Loading
}