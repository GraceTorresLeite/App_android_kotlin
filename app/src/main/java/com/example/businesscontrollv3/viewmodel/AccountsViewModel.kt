package com.example.businesscontrollv3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.businesscontrollv3.model.Account
import com.example.businesscontrollv3.repository.AccountRepository

class AccountsViewModel : ViewModel() {
    private val index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(index) {
        "Seção $it onde ficarão a lista de contas"
    }

    fun setIndex(index: Int) {
        this.index.value = index
    }

    /*fun getAccounts(): List<Account>{
        return AccountRepository().getAllAccounts()
    }*/ // versão abaixo está simplificada
    fun getAccounts() = AccountRepository().getAllAccounts()

}