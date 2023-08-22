package com.adciasis.recoveryfy.repository

import com.adciasis.recoveryfy.data.LoginRequest
import com.adciasis.recoveryfy.network.NetworkConnector
import com.adciasis.recoveryfy.apis.RecoveryfyAPIServices
import com.adciasis.recoveryfy.data.LoginResponse

class RecoveryfyRepositoryImpl constructor(
    private val networkConnector: NetworkConnector,
    private val recoveryfyAPIServices: RecoveryfyAPIServices,
) : RecoveryfyRepository.LoginRepo {

    override fun loginUser(loginRequest: LoginRequest) = networkConnector.toResultFlow<LoginResponse> {
        recoveryfyAPIServices.loginUser(loginRequest)
    }

}