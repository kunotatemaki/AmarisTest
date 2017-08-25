package com.rukiasoft.amaristest.resources

import com.rukiasoft.amaristest.model.Account

/**
 * Created by Roll on 24/8/17.
 */
interface ResourcesManager {

    fun loadAccounts(): MutableList<Account>

    fun getString(resId: Int): String

}