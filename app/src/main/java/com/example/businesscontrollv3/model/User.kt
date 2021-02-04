package com.example.businesscontrollv3.model

import com.google.gson.annotations.SerializedName

data class User(
        @SerializedName("nome")
        val name:String,
        val email:String
)
