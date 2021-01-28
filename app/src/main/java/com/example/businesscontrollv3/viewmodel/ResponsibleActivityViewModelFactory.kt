package com.example.businesscontrollv3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.businesscontrollv3.repository.LoginRepository
import com.example.businesscontrollv3.view.ResponsibleActivity

object ResponsibleActivityViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResponsibleViewModel::class.java)) {
            return ResponsibleViewModel() as T
        }

        throw IllegalAccessException("Erro desconhecido")
    }

}