package com.example.businesscontrollv3.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.databinding.Bindable
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.model.Responsible
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ResponsibleViewModel: BaseViewModel() {

    @Bindable
    var name: String = ""

    private val gson: Gson = Gson()

    fun saveResponsible(context: Context){

        val sharedPref = context.getSharedPreferences(
            context.getString(R.string.preference_list_responsible), Context.MODE_PRIVATE
        )?:return // se retornar vazio ele só finaliza a função

        val stringResponsibles = sharedPref.getString( context.getString(R.string.preference_list_responsible), "")

        println(stringResponsibles)

        val type: Type = object: TypeToken<List<Responsible>>() {}.type
        val listResponsibles : MutableList<Responsible> =
            if (stringResponsibles.isNullOrBlank()) mutableListOf()
        else gson.fromJson(stringResponsibles, type) // tipo: nossa lista de responsaveis

        val novoResponsavel = Responsible(name)
        listResponsibles.add(novoResponsavel)

        with(sharedPref.edit()){
            putString(context.getString(R.string.preference_list_responsible), gson.toJson(listResponsibles))
            commit()
        }

    }

    /*fun showMessageToast (context: Context) {
        Toast.makeText(context, this.name, Toast.LENGTH_LONG).show()
     }*/
}