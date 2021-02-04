package com.example.businesscontrollv3.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.databinding.ActivityLoginBinding
import com.example.businesscontrollv3.viewmodel.LoginActivityViewModel
import com.example.businesscontrollv3.viewmodel.LoginActivityViewModelFactory
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginActivityViewModel by lazy {
        ViewModelProvider(this, LoginActivityViewModelFactory)
            .get(LoginActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.viewmodel = loginViewModel

        redirectToMainActivity()


        // TODO: Codigo provisorio
        loginViewModel.email = "teste@teste.com"
        loginViewModel.password = "teste"
        loginViewModel.doLogin()

    }

    fun login(view: View) {
        if (loginViewModel.formIsValid()) {
            loginViewModel.doLogin()
        } else {
            when {
                loginViewModel.password.isBlank() -> passwordET.error = getString(R.string.password_blank)
                loginViewModel.email.isBlank() -> emailET.error = getString(R.string.email_blank)
                else -> emailET.error = getString(R.string.email_invalid)
            }
        }
    }

    fun redirectToMainActivity() {
        loginViewModel.redirect.observe(this) {
            if (it) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}