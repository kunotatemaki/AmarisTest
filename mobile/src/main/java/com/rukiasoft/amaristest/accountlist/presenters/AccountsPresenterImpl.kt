package com.rukiasoft.amaristest.accountlist.presenters

import com.rukiasoft.amaristest.dependencyInjection.scopes.CustomScopes
import javax.inject.Inject

/**
 * Created by Roll on 24/8/17.
 */
@CustomScopes.ActivityScope
class AccountsPresenterImpl @Inject constructor(): AccountsPresenter {


    override fun loadAccounts() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}