package com.example.businesscontrollv3.model

import java.math.BigDecimal
import java.util.*

class Transaction(val id: Int, val data: Calendar, val valor: BigDecimal,
                  val descricao: String, val responsible:Responsible, val conta: Account,
                  val tipoTransacaoEnum:TipoTransacaoEnum,
                  val tipoRendaEnum:TipoRendaEnum, val categoriaDespesaEnum:CategoriaDespesaEnum) {

    /*var tipoRendaEnum:TipoRendaEnum? = null
    var categoriaDespesaEnum:CategoriaDespesaEnum? = null*/

}