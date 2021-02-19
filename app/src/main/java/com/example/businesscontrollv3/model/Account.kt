package com.example.businesscontrollv3.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity
data class Account(
        @ColumnInfo
        val name: String,
        @ColumnInfo
        val balance: BigDecimal,
        @ColumnInfo
        val reponsible:Responsible,
        @ColumnInfo
        val accountTypeEnum:AccountTypeEnum) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var idAccount: Int? = null

}