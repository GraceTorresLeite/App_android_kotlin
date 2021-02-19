package com.example.businesscontrollv3.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.databinding.ActivityAccountBinding
import com.example.businesscontrollv3.model.AccountTypeEnum
import com.example.businesscontrollv3.model.Responsible
import com.example.businesscontrollv3.view.MainActivity
import com.example.businesscontrollv3.viewmodel.AccountsViewModel
import kotlinx.android.synthetic.main.activity_account.*
import java.math.BigDecimal

class AccountActivity: AppCompatActivity() {

    private val accountsViewModel: AccountsViewModel by lazy {
        ViewModelProvider(this, AccountsViewModel)
                .get(AccountsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityAccountBinding = DataBindingUtil.setContentView(this, R.layout.activity_account)

        binding.accountsViewModel = accountsViewModel

        redirectToMainActivity()



        // TODO: Codigo provisorio
        accountsViewModel.name = "Matias"
        accountsViewModel.balance = BigDecimal.valueOf(1000)
        accountsViewModel.responsible = Responsible("Matias")
        accountsViewModel.accountType = AccountTypeEnum.DEBITO

        accountsViewModel.setIndex()
    }

    fun login(view: View) {
        if (accountsViewModel.formIsValid()) {
            accountsViewModel.doAccount()
        } else {
            when {
                accountsViewModel.name.isBlank() -> nameET.error = getString(R.string.app_name)

            }
        }
    }

    fun redirectToMainActivity() {
        accountsViewModel.redirect.observe(this, {
            if (it) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }

}