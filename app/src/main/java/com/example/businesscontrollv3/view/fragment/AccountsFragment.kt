package com.example.businesscontrollv3.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.view.adapter.AccountAdapter
import com.example.businesscontrollv3.viewmodel.AccountsViewModel
import kotlinx.android.synthetic.main.fragment_accounts.*


class AccountsFragment : Fragment() {

    private lateinit var accountsViewModel: AccountsViewModel

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        accountsViewModel = ViewModelProvider(this).get(AccountsViewModel::class.java).apply {
            setIndex(arguments?.getInt(AccountsFragment.ARG_SECTION_NUMBER) ?:1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?{
        val root = inflater.inflate(R.layout.fragment_accounts, container, false)

       /* accountsViewModel.text.observe(viewLifecycleOwner){
            section_label.text = it
        }*/

        val recyclerView = root.findViewById<RecyclerView>(R.id.accountsRecicleView)
        recyclerView.adapter = AccountAdapter(accountsViewModel.getAccounts())
        recyclerView.setHasFixedSize(true)
        return root
    }
    companion object{
        const val ARG_SECTION_NUMBER = "section_number"
    }
}