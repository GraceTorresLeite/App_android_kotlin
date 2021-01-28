package com.example.businesscontrollv3.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.model.Account


class AccountAdapter (private val accountList:List<Account>): RecyclerView.Adapter<AccountAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_account, parent,false)//tem que retornar o ViewHolder e tem que passar o item
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return accountList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.accountNameTV.text = accountList[position].name
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val accountNameTV: TextView = itemView.findViewById(R.id.accountNameTV)
    }

}