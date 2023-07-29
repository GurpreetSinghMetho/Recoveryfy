package com.adciasis.recoveryfy.repository

import com.adciasis.recoveryfy.data.LoginRequest
import com.adciasis.recoveryfy.data.LoginResponse
import com.adciasis.recoveryfy.apis.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body

interface RecoveryfyRepository {

    interface LoginRepo{
        fun loginUser(
            @Body loginRequest: LoginRequest,
        ): Flow<Resource<LoginResponse>>
    }
}