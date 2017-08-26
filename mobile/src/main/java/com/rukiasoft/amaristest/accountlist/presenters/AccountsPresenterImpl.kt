package com.rukiasoft.amaristest.accountlist.presenters

import android.support.annotation.VisibleForTesting
import com.rukiasoft.amaristest.accountlist.ui.livedataobservers.LivedataObserver
import com.rukiasoft.amaristest.accountlist.ui.mainviews.AccountsView
import com.rukiasoft.amaristest.dependencyInjection.scopes.CustomScopes
import com.rukiasoft.amaristest.model.Account
import com.rukiasoft.amaristest.resources.ResourcesManager
import com.rukiasoft.amaristest.utils.AmarisConstants
import com.rukiasoft.amaristest.utils.logger.AndroidLogHelperImpl
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import javax.inject.Inject


/**
 * Created by Roll on 24/8/17.
 */
@CustomScopes.ActivityScope
open class AccountsPresenterImpl @Inject constructor(val mView: AccountsView) : AccountsPresenter, LivedataObserver {

    @Inject
    lateinit var resourcesManager: ResourcesManager

    @Inject
    lateinit var log: LoggerHelper

    @VisibleForTesting
    constructor(resourcesManager: ResourcesManager, log: AndroidLogHelperImpl, mView: AccountsView) : this(mView) {
        this.resourcesManager = resourcesManager
        this.log = log

    }

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

    override fun getResourceManager(): ResourcesManager{
        return resourcesManager
    }

    override fun accountClicked(account: Account) {
        log.d(this, "he pulsado: " + account.accountBalanceInCents)
        mView.showAccountDetails(account)

    }

    override fun showDataInMainView(accounts: MutableList<Account>?){
        accounts?: return
        val filteredAccounts: MutableList<Account> = getFilteredAccounts(accounts)
        mView.setAccountsInView(filteredAccounts)
    }

    fun getFilteredAccounts(accounts: MutableList<Account>): MutableList<Account>{
        val filteredAccounts: MutableList<Account> = mutableListOf()
        when(mView.getSelectedType()){
            AmarisConstants.Type.ALL->{
                log.d(this, "show all")
                filteredAccounts.addAll(accounts)}
            AmarisConstants.Type.VISIBLE -> {
                log.d(this, "show only visible accounts")
                accounts.forEach {
                    if(it.isVisible){
                        filteredAccounts.add(it)
                    }
                }
            }
        }
        return filteredAccounts
    }

    //region LIVEDATA OBSERVER INTERFACE
    override fun handleChangesInObservedAccounts(accounts: MutableList<Account>) {
        log.d(this, "me entero del cambio")
        showDataInMainView(accounts)

    }
    //endregion

}