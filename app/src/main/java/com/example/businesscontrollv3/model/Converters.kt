package com.example.businesscontrollv3.model.type

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun toAccountType(accountType: String) = AccountTypeEnum.valueOf(accountType)

    @TypeConverter
    fun fromAccountType(accountTypeEnum: AccountTypeEnum) = accountTypeEnum.name
}