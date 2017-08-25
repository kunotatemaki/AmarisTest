package com.rukiasoft.amaristest.accountlist.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.rukiasoft.amaristest.R
import com.rukiasoft.amaristest.accountlist.presenters.AccountsPresenter
import com.rukiasoft.amaristest.accountlist.ui.viewholders.AccountsViewHolder
import com.rukiasoft.amaristest.databinding.AccountItemBinding
import com.rukiasoft.amaristest.model.Account
import javax.inject.Inject

/**
 * Created by Roll on 24/8/17.
 */
class AccountsAdapter @Inject constructor(val presenter: AccountsPresenter):
        RecyclerView.Adapter<AccountsViewHolder>() {

    val accounts: MutableList<Account> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AccountsViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val binding = DataBindingUtil.inflate<AccountItemBinding>(inflater, R.layout.account_item, parent, false)
        return AccountsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AccountsViewHolder?, position: Int) {
        val account: Account = accounts[position]
        holder?.bind(account, presenter)
    }

    override fun getItemCount(): Int {
        return accounts.size
    }

}