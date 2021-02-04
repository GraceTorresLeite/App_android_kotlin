package com.example.businesscontrollv3.repository

import com.example.businesscontrollv3.infra.webservice.LoginAPI.loginService
import com.example.businesscontrollv3.infra.webservice.LoginHttp
import com.example.businesscontrollv3.model.Login
import com.example.businesscontrollv3.model.Result
import com.example.businesscontrollv3.model.User
import okhttp3.ResponseBody

class LoginRepository {

    suspend fun loginOld(email: String, password: String): Result<User> {
        return LoginHttp.doLogin(Login(email, password))
    }

    
    suspend fun login(email: String, password: String): Result<User>{
        return try{
            val response = loginService.login(Login(email,password))
            if(response.isSuccessful){
                Result.Success(response.body()!!)
            }else{
                val responseErrorBody = response.errorBody() as ResponseBody
                Result.Error(Exception(responseErrorBody?.string()))
            }
        }catch (e:Exception){
            println(e)
            Result.Error(e)
        }
    }

   /* private suspend fun simulacaoDeChamadaParaService(email: String, password: String): Result<Login> {
        delay(2000)

          return when(verifyPassword(email, password)) {
            true -> Result.Success(Login(email, password))
            false -> Result.Error(Exception("Email ou senha Invalidos"))
        }

    }

    private fun verifyPassword(email: String, password: String): Boolean {
        val fakeUser = Login("teste@teste.com", "teste")

        return email == fakeUser.email && password == fakeUser.password
    }*/

}