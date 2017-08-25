package com.rukiasoft.amaristest.accountlist.ui.viewmodels

import android.arch.lifecycle.ViewModel
import com.rukiasoft.amaristest.model.Account
import com.rukiasoft.amaristest.model.AccountsLiveData
import com.rukiasoft.amaristest.model.CustomLiveData

/**
 * Created by Roll on 24/8/17.
 */
class AccountsViewModel: ViewModel() {
    var listOfAccounts: CustomLiveData<MutableList<Account>> = AccountsLiveData()
}