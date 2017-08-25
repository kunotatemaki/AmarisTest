package com.rukiasoft.amaristest.accountlist.presenters

import com.rukiasoft.amaristest.accountlist.ui.livedataobservers.LivedataObserver
import com.rukiasoft.amaristest.accountlist.ui.mainviews.AccountsView
import com.rukiasoft.amaristest.dependencyInjection.scopes.CustomScopes
import com.rukiasoft.amaristest.model.Account
import com.rukiasoft.amaristest.resources.ResourcesManager
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import javax.inject.Inject


/**
 * Created by Roll on 24/8/17.
 */
@CustomScopes.ActivityScope
class AccountsPresenterImpl @Inject constructor(val mView: AccountsView) : AccountsPresenter, LivedataObserver {

    @Inject
    lateinit var resourcesManager: ResourcesManager

    @Inject
    lateinit var log: LoggerHelper

    override fun loadAccounts() {
        //check if there is data in cache
        val accounts = mView.getLiveAccounts().getLivedataValue()
        if (accounts != null && !accounts.isEmpty()) {
            //cached data
            mView.setAccountsInView(accounts)
        } else {
            log.d(this, "load accounts")
            val accountList = resourcesManager.loadAccounts()
            log.d(this, "set data in observable")
            mView.getLiveAccounts().setLivedataValue(accountList)
            log.d(this, "metido")
        }

    }

    //region LIVEDATA OBSERVER INTERFACE
    override fun handleChangesInObservedAccounts(accounts: MutableList<Account>) {
        log.d(this, "me entero del cambio")
        mView.setAccountsInView(accounts)
    }
    //endregion

}