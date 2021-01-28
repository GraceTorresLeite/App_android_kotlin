package com.example.businesscontrollv3.viewmodel

import android.util.Patterns
import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.businesscontrollv3.BR
import com.example.businesscontrollv3.model.Result
import com.example.businesscontrollv3.model.Usuario
import com.example.businesscontrollv3.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivityViewModel(val loginRepository: LoginRepository) : BaseViewModel() {

    @Bindable
    var email: String = "teste@teste.com"

    @Bindable
    var password: String = ""

    @Bindable
    var loadingVisibility: Int = View.GONE
        set(value) {
            field = value
            notifyPropertyChanged(BR.loadingVisibility)
        }

    @Bindable
    var errorMessage: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.errorMessage)
        }

    val redirect: MutableLiveData<Boolean> = MutableLiveData(false)

    fun formIsValid(): Boolean =
            this.password.isNotBlank() &&
                    this.email.isNotBlank() &&
                    Patterns.EMAIL_ADDRESS.matcher(this.email).matches()

    fun doLogin() {
        this.loadingVisibility = View.VISIBLE

        // CHECAGEM
        viewModelScope.launch(Dispatchers.IO) {
            val result = loginRepository.login(email, password)

            when(result) {
                is Result.Success<Usuario> -> redirect.postValue(true)
                is Result.Error -> showError(result.exception.message)
            }

            loadingVisibility = View.GONE
        }
    }

    private fun showError(message: String?) {
        this.errorMessage = message ?: "Erro Desconhecido"
    }

}