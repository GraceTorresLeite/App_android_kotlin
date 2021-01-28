package com.example.businesscontrollv3.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.view.adapter.MainSectionsPagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sectionsPagerAdapter = MainSectionsPagerAdapter(lifecycle, supportFragmentManager)
        pager.adapter = sectionsPagerAdapter

        TabLayoutMediator(tabs, pager) { tab, position ->
            tab.text = when (position) {
                0 -> "Resumo"
                1 -> "Transações"
                2 -> "Contas"
                else -> ""
            }
        }.attach()

        bottomNavigationMenu.setOnNavigationItemSelectedListener(
                this::onOptionsItemSelected
        )

        bottomNavigationMenu.uncheckAllItems()  // aula 9 - 22/01/2021 - chamando o nosso rack - invenção nossa
    }

    fun showSnackBar(view: View) {
        Snackbar
            .make(view, R.string.snack_bar_text, Snackbar.LENGTH_INDEFINITE)
            .setAction(R.string.sair_text) {
                finish()
            }
            .show()
    }

    private fun BottomNavigationView.uncheckAllItems(){ // aula 9 dia 22/01/2021 criar subgrupos -
        // é um rack, extendendo a classe com uma funçaõ que eu mesmo criei (extende colocando um ponto)
        menu.setGroupCheckable(0, true,false)
        for (i in 0 until menu.size()) {
            menu.getItem(i).isChecked = false
        }
        menu.setGroupCheckable(0,true,true)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        Toast.makeText(applicationContext, R.string.toast_text, Toast.LENGTH_LONG).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {// só executa se for selecionada
        return when(item.itemId){
            R.id.new_responsible -> {
                intent = Intent(this, ResponsibleActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.new_transaction -> true
            R.id.new_accounts -> true
            R.id.navigation_configurations -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}