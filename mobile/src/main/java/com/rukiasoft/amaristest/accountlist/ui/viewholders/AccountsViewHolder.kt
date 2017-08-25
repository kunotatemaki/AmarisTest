package com.rukiasoft.amaristest.accountlist.ui.viewholders

import android.support.v7.widget.RecyclerView
import com.rukiasoft.amaristest.BR
import com.rukiasoft.amaristest.accountlist.presenters.AccountsPresenter
import com.rukiasoft.amaristest.databinding.AccountItemBinding
import com.rukiasoft.amaristest.model.Account

/**
 * Created by Roll on 24/8/17.
 */
class AccountsViewHolder(val binding: AccountItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(account: Account, presenter: AccountsPresenter) {
        binding.setVariable(BR.account, account)
        binding.setVariable(BR.presenter, presenter)
        binding.executePendingBindings()
    }

}