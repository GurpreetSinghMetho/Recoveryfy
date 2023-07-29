package com.adciasis.recoveryfy.apis

import com.adciasis.recoveryfy.data.LoginRequest
import com.adciasis.recoveryfy.data.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface RecoveryfyAPIServices {

    @POST(ApiUrls.Login)
    suspend fun loginUser(
        @Body loginRequest: LoginRequest,
    ): Response<LoginResponse>?
}