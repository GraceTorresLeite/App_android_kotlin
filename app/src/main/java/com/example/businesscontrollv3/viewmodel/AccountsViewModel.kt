package com.example.businesscontrollv3.viewmodel

import android.util.Patterns
import android.view.View
import androidx.databinding.Bindable
import androidx.lifecycle.*
import com.example.businesscontrollv3.BR
import com.example.businesscontrollv3.infra.database.AccountDAO
import com.example.businesscontrollv3.model.*
import com.example.businesscontrollv3.repository.AccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.math.BigDecimal

class AccountsViewModel(private val accountRepository: AccountRepository) : ViewModel() {
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

    val allAccounts = accountRepository.allAccounts.asLiveData()

    @Bindable
    var name: String = ""
    var balance: BigDecimal = BigDecimal.valueOf(1000)
    var responsible: Responsible = Responsible("Matias")
    var accountType: AccountTypeEnum = AccountTypeEnum.DEBITO

    @Bindable
    var loadingVisibility: Int = View.GONE
        set(value) {
            field = value
            notifyPropertyChanged(BR.loadingVisibility)
        }
    fun formIsValid(): Boolean =
            this.name.isNotBlank()

    fun doAccount() {
        this.loadingVisibility = View.VISIBLE

        // CHECAGEM
        viewModelScope.launch(Dispatchers.IO) {
            val result = accountRepository.allAccounts

            when(result) {
                is Result.Success<User> -> redirect.postValue(true)
                is Result.Error -> showError(result.exception.message)
            }

            loadingVisibility = View.GONE
        }
    }

    val redirect: MutableLiveData<Boolean> = MutableLiveData(false)

    private fun showError(message: String?) {
        this.errorMessage = message ?: "Erro Desconhecido"
    }

    fun saveAccounts() = viewModelScope.launch {
        val account = Account(name,balance,responsible,accountType)

        fun getAccounts() = AccountDAO().save(account)

}