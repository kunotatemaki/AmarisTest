package com.rukiasoft.amaristest.accountlist.presenters

import com.rukiasoft.amaristest.resources.ResourcesManager

/**
 * Created by Roll on 24/8/17.
 */
interface AccountsPresenter {

    fun loadAccounts()

    fun getResourceManager(): ResourcesManager
}