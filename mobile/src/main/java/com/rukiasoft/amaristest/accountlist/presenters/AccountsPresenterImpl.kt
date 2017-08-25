package com.rukiasoft.amaristest.accountlist.presenters

import com.rukiasoft.amaristest.dependencyInjection.scopes.CustomScopes
import com.rukiasoft.amaristest.resources.ResourcesManager
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import javax.inject.Inject

/**
 * Created by Roll on 24/8/17.
 */
@CustomScopes.ActivityScope
class AccountsPresenterImpl @Inject constructor(): AccountsPresenter {

    @Inject
    protected lateinit var resourcesManager: ResourcesManager

    @Inject
    protected lateinit var log: LoggerHelper

    override fun loadAccounts() {
        log.d(this, "leo las cuentas")
        resourcesManager.loadAccounts()
    }

}