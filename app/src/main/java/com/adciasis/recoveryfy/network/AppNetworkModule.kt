package com.adciasis.recoveryfy.network

import com.adciasis.recoveryfy.apis.ApiUrls
import com.adciasis.recoveryfy.apis.RecoveryfyAPIServices
import com.adciasis.recoveryfy.repository.RecoveryfyRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppNetworkModule {

    @Singleton
    @Provides
    fun providesRetrofitClient(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(ApiUrls.BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun providesOkHttpClientClient() = OkHttpClient.Builder().apply {
        addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
    }.readTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS).build()

    @Provides
    @Singleton
    fun provideRecoveryfyAPIServices(retrofit: Retrofit): RecoveryfyAPIServices =
        retrofit.create(RecoveryfyAPIServices::class.java)

    @Provides
    @Singleton
    fun providesDispatcher(): DispatcherProvider = DefaultDispatcherProvider()

    @Singleton
    @Provides
    fun networkConnector(dispatcherProvider: DispatcherProvider): NetworkConnector =
        NetworkConnector(dispatcherProvider)

    @Singleton
    @Provides
    fun providesRecoveryfyRepositoryImpl(
        networkConnector: NetworkConnector,
        recoveryfyAPIServices: RecoveryfyAPIServices,
    ): RecoveryfyRepositoryImpl =
        RecoveryfyRepositoryImpl(networkConnector, recoveryfyAPIServices)
}