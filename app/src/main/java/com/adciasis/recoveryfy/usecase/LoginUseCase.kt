package com.adciasis.recoveryfy.usecase

import com.adciasis.recoveryfy.data.LoginRequest
import com.adciasis.recoveryfy.repository.RecoveryfyRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepo: RecoveryfyRepository.LoginRepo) {

    fun login(loginRequest: LoginRequest) = loginRepo.loginUser(loginRequest)
}