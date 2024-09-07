package com.adciasis.recoveryfy.network

import com.adciasis.recoveryfy.repository.RecoveryfyRepository
import com.adciasis.recoveryfy.repository.RecoveryfyRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseProvider {

    @Singleton
    @Provides
    fun providesRecoveryfyLoginRepo(
        recoveryfyRepositoryImpl: RecoveryfyRepositoryImpl,
    ): RecoveryfyRepository.LoginRepo = recoveryfyRepositoryImpl

    @Singleton
    @Provides
    fun providesProfileDetails(
        recoveryfyRepositoryImpl: RecoveryfyRepositoryImpl,
    ): RecoveryfyRepository.ProfileDetails = recoveryfyRepositoryImpl

}