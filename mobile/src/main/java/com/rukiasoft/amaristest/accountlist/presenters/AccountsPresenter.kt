package com.rukiasoft.amaristest.accountlist.presenters

import com.rukiasoft.amaristest.model.Account
import com.rukiasoft.amaristest.resources.ResourcesManager

/**
 * Created by Roll on 24/8/17.
 */
interface AccountsPresenter {

    fun loadAccounts()

    fun getResourceManager(): ResourcesManager
    fun accountClicked(account: Account)
    fun showDataInMainView(accounts: MutableList<Account>?)
}