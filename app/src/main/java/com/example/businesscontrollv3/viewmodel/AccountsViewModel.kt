package com.example.businesscontrollv3.viewmodel

import android.view.View
import androidx.databinding.Bindable
import androidx.lifecycle.*
import com.example.businesscontrollv3.BR
import com.example.businesscontrollv3.infra.database.AccountDAO
import com.example.businesscontrollv3.model.*
import com.example.businesscontrollv3.model.type.AccountTypeEnum
import com.example.businesscontrollv3.repository.AccountRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.math.BigDecimal

class AccountsActivityViewModel(private val accountRepository: AccountRepository) : BaseViewModel() {

    @Bindable
    var name: String = ""
    @Bindable
    val balance: Double = 1.0
    //var balance: BigDecimal = BigDecimal.valueOf(1000)
    @Bindable
    val responsible: Int? = null
    //var responsible: Responsible = Responsible("Matias")
    @Bindable
    val accountType: AccountTypeEnum? = null
    //var accountType: AccountTypeEnum = AccountTypeEnum.DEBITO

    fun getAccount() = accountRepository.getAllAccount().asLiveData()

    fun save() = viewModelScope.launch {
        val account = Account(name, balance, Responsible(responsible.toString()), enumValueOf(name))

        accountRepository.save(account)
    }

    /*@Bindable
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

        //private val index = MutableLiveData<Int>()
        //val text: LiveData<String> = Transformations.map(index) {
        //    "Seção $it onde ficarão a lista de contas"
        // }

        // fun setIndex(index: Int) {
        //    this.index.value = index
        // }

        /*fun getAccounts(): List<Account>{
            return AccountRepository().getAllAccounts()
        }*/ // versão abaixo está simplificada

        // val allAccounts = accountRepository.allAccounts.asLiveData()

    */
    }