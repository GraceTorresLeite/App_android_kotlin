package com.example.businesscontrollv3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.businesscontrollv3.repository.LoginRepository

object LoginActivityViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginActivityViewModel::class.java)) {
            val repository = LoginRepository()
            return LoginActivityViewModel(repository) as T
        }

        throw IllegalAccessException("Erro desconhecido")
    }

}