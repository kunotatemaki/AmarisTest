package com.rukiasoft.amaristest.accountlist.presenters

import com.rukiasoft.amaristest.accountlist.ui.mainviews.AccountsView
import com.rukiasoft.amaristest.dependencyInjection.scopes.CustomScopes
import com.rukiasoft.amaristest.resources.ResourcesManager
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import javax.inject.Inject

/**
 * Created by Roll on 24/8/17.
 */
@CustomScopes.ActivityScope
class AccountsPresenterImpl @Inject constructor(val mView: AccountsView) : AccountsPresenter {

    @Inject
    protected lateinit var resourcesManager: ResourcesManager

    @Inject
    protected lateinit var log: LoggerHelper

    override fun loadAccounts() {
        log.d(this, "load accounts")
        val accountList = resourcesManager.loadAccounts()
        log.d(this, "set data in observable")
        mView.getLiveAccounts().setLivedataValue(accountList)
        log.d(this, "metido")
    }

}