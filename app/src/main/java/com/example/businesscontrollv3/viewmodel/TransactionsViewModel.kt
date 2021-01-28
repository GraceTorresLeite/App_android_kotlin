package com.example.businesscontrollv3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class TransactionsViewModel : ViewModel() {
    private val index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(index) {
        "Seção $it onde ficarão a lista de transações"
    }

    fun setIndex(index: Int) {
        this.index.value = index
    }
    
}