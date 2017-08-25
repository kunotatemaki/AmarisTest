package com.rukiasoft.amaristest.accountlist.ui.mainviews

import com.rukiasoft.amaristest.accountlist.ui.lifecycleobservers.AccountsLifecycleObserver
import com.rukiasoft.amaristest.model.Account
import com.rukiasoft.amaristest.model.CustomLiveData
import com.rukiasoft.amaristest.utils.AmarisConstants


/**
 * Created by Roll on 24/8/17.
 */
interface AccountsView {

    fun setAccountsInView(accounts: List<Account>)

    fun addLifecycleObserver(observer: AccountsLifecycleObserver)

    fun getLiveAccounts(): CustomLiveData<MutableList<Account>>

    fun getSelectedType(): AmarisConstants.Type
    fun showAccountDetails(account: Account)
}