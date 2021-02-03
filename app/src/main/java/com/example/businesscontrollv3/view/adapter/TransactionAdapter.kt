package com.example.businesscontrollv3.view.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.model.Transaction

class TransactionAdapter(private val transactionList:List<Transaction>):
    RecyclerView.Adapter<TransactionAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_account, parent,false)//tem que retornar o ViewHolder e tem que passar o item
        return TransactionAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return transactionList.size
    }

    override fun onBindViewHolder(holder: TransactionAdapter.ViewHolder, position: Int) {
        holder.transactionIdTV.text = transactionList[position].id.toString()
        holder.transactionDataTV.text = transactionList[position].data.toString()
        holder.transactionValorTV.text = transactionList[position].valor.toString()
        holder.transactionDescricaoTV.text = transactionList[position].descricao
        holder.transactionContaTV.text = transactionList[position].conta.toString()
        holder.transactionTipoTransicaoEnumTV.text = transactionList[position].tipoTransacaoEnum.toString()
        holder.transactionTipoRendaEnumTV.text = transactionList[position].tipoRendaEnum.toString()
        holder.transactionCategoriaEnumTV.text = transactionList[position].categoriaDespesaEnum.toString()

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val transactionIdTV: TextView = itemView.findViewById(R.id.transactionIdTV)
        val transactionDataTV: TextView = itemView.findViewById(R.id.transactionDataTV)
        val transactionValorTV: TextView = itemView.findViewById(R.id.transactionValorTV)
        val transactionDescricaoTV: TextView = itemView.findViewById(R.id.transactionDescricaoTV)
        val transactionContaTV: TextView = itemView.findViewById(R.id.transactionContaTV)
        val transactionTipoTransicaoEnumTV: TextView = itemView.findViewById(R.id.transactionTipoTransicaoEnumTV)
        val transactionTipoRendaEnumTV: TextView = itemView.findViewById(R.id.transactionTipoRendaEnumTV)
        val transactionCategoriaEnumTV: TextView = itemView.findViewById(R.id.transactionCategoriaEnumTV)
    }


}