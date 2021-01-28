package com.example.businesscontrollv3.view

import android.os.Bundle
import android.view.ActionMode
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.databinding.ActivityLoginBinding
import com.example.businesscontrollv3.databinding.ActivityResponsibleBinding
import com.example.businesscontrollv3.viewmodel.ResponsibleActivityViewModelFactory
import com.example.businesscontrollv3.viewmodel.ResponsibleViewModel

class ResponsibleActivity: AppCompatActivity() {

    private val responsibleViewModel: ResponsibleViewModel by lazy {
        ViewModelProvider(this, ResponsibleActivityViewModelFactory).get(ResponsibleViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityResponsibleBinding = DataBindingUtil.setContentView(this, R.layout.activity_responsible)

        binding.responsibleViewModel = responsibleViewModel

        supportActionBar?.setDisplayHomeAsUpEnabled(true) // verifica se existe
    // uma barra de navegação e se tiver vai setar um botão de setar
    // - supportActionBar (pode ser vazio) eu nãoposso simplesmente botar ponto, posso colocar !! e correr o risco de dar um Nullpointer
    // para o cliente/ com ponto de interrogação ? só chama se for null
    }

    fun save(view: View){
        responsibleViewModel.saveResponsible(applicationContext)
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
         }
    }

   /*fun onclick (view: View) {
        responsibleViewModel.showMessageToast(applicationContext)
        finish()
    }*/
}