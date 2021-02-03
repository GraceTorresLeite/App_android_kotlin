package com.example.businesscontrollv3.repository

import com.example.businesscontrollv3.model.*
import java.math.BigDecimal
import java.util.*

class TransactionRepository {

    fun getAllAccounts(): MutableList<Transaction>{
        val responsible = Responsible("Matias")
        val conta = Account("banco1",BigDecimal.TEN,responsible, AccountTypeEnum.DEBITO)
        val data = Calendar.getInstance()
        val reembolso = TipoRendaEnum.REEMBOLSO
        val produtoReembolso = CategoriaDespesaEnum.SERVIDOR_WEB
        val pagamentoSalarios = TipoRendaEnum.SALARIO
        val funcionariosCondominio = CategoriaDespesaEnum.CONDOMINIO


        val cards = mutableListOf(
            Transaction(1, data,BigDecimal.valueOf(2000),
                "transferência",responsible,conta,TipoTransacaoEnum.TRANSFERENCIA,reembolso,produtoReembolso),
            Transaction(3,data, BigDecimal.valueOf(7500),
                "Despesa", responsible,conta,TipoTransacaoEnum.DESPESA, pagamentoSalarios,funcionariosCondominio)
        )
        for (i in 0 until 3){
            cards.add(
                Transaction(i,data, BigDecimal.valueOf(15000), "Receita",
                    responsible,conta,TipoTransacaoEnum.RECEITA,TipoRendaEnum.RENDIMENTO,CategoriaDespesaEnum.CONDOMINIO)

            )
        }
        return cards

    }
}