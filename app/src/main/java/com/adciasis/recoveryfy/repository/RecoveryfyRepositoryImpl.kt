package com.adciasis.recoveryfy.repository

import com.adciasis.recoveryfy.data.LoginRequest
import com.adciasis.recoveryfy.network.NetworkConnector
import com.adciasis.recoveryfy.apis.RecoveryfyAPIServices

class RecoveryfyRepositoryImpl constructor(
    private val networkConnector: NetworkConnector,
    private val recoveryfyAPIServices: RecoveryfyAPIServices,
) : RecoveryfyRepository.LoginRepo {

    override fun loginUser(loginRequest: LoginRequest) = networkConnector.toResultFlow {
        recoveryfyAPIServices.loginUser(loginRequest)
    }

}