package com.adciasis.recoveryfy.network

import com.adciasis.recoveryfy.apis.ErrorResponse
import com.adciasis.recoveryfy.apis.NetworkState
import com.adciasis.recoveryfy.apis.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class NetworkConnector(private val dispatcher: DispatcherProvider) {

    fun <T> toResultFlow(call: suspend () -> Response<T>?): Flow<Resource<T>> {
        return flow {
            emit(Resource<T>(networkState = NetworkState.Loading))
            try {
                val c = call()
                c?.let {
                    if (c.isSuccessful) {
                        emit(Resource(data = c.body(), networkState = NetworkState.Success))
                    } else {
                        c.errorBody()?.let {
                            val error = it.string()
                            it.close()
                            emit(Resource<T>(errorResponse = ErrorResponse(msg = error), networkState = NetworkState.Error))
                        }
                    }
                }
            } catch (e: Exception) {
                emit(Resource<T>(errorResponse = ErrorResponse(msg = e.message), networkState = NetworkState.Error))
            }

        }.flowOn(dispatcher.io())
    }
}