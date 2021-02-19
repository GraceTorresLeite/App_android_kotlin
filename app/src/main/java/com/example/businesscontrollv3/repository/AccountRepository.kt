package com.example.businesscontrollv3.repository

import androidx.annotation.WorkerThread
import com.example.businesscontrollv3.infra.database.AccountDAO
import com.example.businesscontrollv3.model.Account


class AccountRepository (private val accountDAO: AccountDAO){

    val allAccounts = accountDAO.getAllAccounts()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun save(account: Account){
        accountDAO.save(account)
    }

    /*fun getAllAccounts(): MutableList<Account>{
        val responsible = Responsible("Matias")

        val list = mutableListOf(
                Account("Banco1", BigDecimal.TEN, responsible,AccountTypeEnum.DEBITO),
                Account("Banco2", BigDecimal.valueOf(1000), responsible,AccountTypeEnum.DEBITO),
        )
        for (i in 0 until 20){
            list.add(
                    Account("Banco $i", BigDecimal.TEN,responsible,AccountTypeEnum.DEBITO)
            )
        }
        return list

    }*/
}