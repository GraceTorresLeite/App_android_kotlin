package com.example.businesscontrollv3.infra.webservice

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LoginAPI {
    
    private const val API_BASE_URL = "https://business-controll-backend.herokuapp.com"
    
    private val okHttpClient: OkHttpClient by lazy{
        val client = OkHttpClient.Builder()
        
        client.addInterceptor(provideLogginInterceptor())
        client.build()
    }
    private val retrofit: Retrofit by lazy{
        Retrofit
            .Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    val loginService: LoginService by lazy{
        retrofit.create(LoginService::class.java)
    }
    
    private fun provideLogginInterceptor(): HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        return logger;
    }
}