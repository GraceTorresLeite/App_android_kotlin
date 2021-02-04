package com.example.businesscontrollv3.infra.webservice

import com.example.businesscontrollv3.model.Login
import com.example.businesscontrollv3.model.User
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response

interface LoginService {
    @POST("/v1/login")
    suspend fun login(@Body login: Login): Response<User>
}