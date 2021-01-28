package com.example.businesscontrollv3.repository

import com.example.businesscontrollv3.model.Account
import com.example.businesscontrollv3.model.AccountTypeEnum
import com.example.businesscontrollv3.model.Responsible
import java.math.BigDecimal

class AccountRepository {

    fun getAllAccounts(): MutableList<Account>{
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
        /*return mutableListOf(
                Account("Banco1", BigDecimal.TEN, responsible,AccountTypeEnum.DEBITO),
                Account("Banco2", BigDecimal.valueOf(1000), responsible,AccountTypeEnum.DEBITO),
        )*/
    }
}