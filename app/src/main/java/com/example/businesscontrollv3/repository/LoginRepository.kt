package com.example.businesscontrollv3.repository

import com.example.businesscontrollv3.model.Usuario
import com.example.businesscontrollv3.model.Result
import kotlinx.coroutines.delay

class LoginRepository {

    suspend fun login(email: String, password: String): Result<Usuario> {
        return this.simulacaoDeChamadaParaService(email, password)
    }

    private suspend fun simulacaoDeChamadaParaService(email: String, password: String): Result<Usuario> {
        delay(2000)

          return when(verifyPassword(email, password)) {
            true -> Result.Success(Usuario(email, password))
            false -> Result.Error(Exception("Email ou senha Invalidos"))
        }

    }

    private fun verifyPassword(email: String, password: String): Boolean {
        val fakeUser = Usuario("teste@teste.com", "teste")

        return email == fakeUser.email && password == fakeUser.password
    }

}