package com.rukiasoft.amaristest.accountlist.ui.livedataobservers

import com.rukiasoft.amaristest.model.Account

/**
 * Created by Roll on 24/8/17.
 */
interface LivedataObserver {

    fun handleChangesInObservedAccounts(accounts: MutableList<Account>)

}