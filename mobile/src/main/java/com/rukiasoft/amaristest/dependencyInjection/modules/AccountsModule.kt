package com.rukiasoft.amaristest.dependencyInjection.modules

import com.rukiasoft.amaristest.accountlist.presenters.AccountsPresenter
import com.rukiasoft.amaristest.accountlist.presenters.AccountsPresenterImpl
import com.rukiasoft.amaristest.accountlist.ui.lifecycleobservers.AccountsLifecycleObserver
import com.rukiasoft.amaristest.accountlist.ui.lifecycleobservers.AccountsLifecycleObserverImpl
import com.rukiasoft.amaristest.accountlist.ui.mainviews.AccountsView
import com.rukiasoft.amaristest.dependencyInjection.scopes.CustomScopes
import dagger.Provides



/**
 * Created by Roll on 24/8/17.
 */
class AccountsModule(private var mView: AccountsView) {

    @Provides
    @CustomScopes.ActivityScope
    fun providesAccountsPresenter(presenter: AccountsPresenterImpl): AccountsPresenter {
        return presenter
    }

    @Provides
    @CustomScopes.ActivityScope
    fun providesAccountsView(): AccountsView {
        return mView
    }

    @Provides
    @CustomScopes.ActivityScope
    fun providesAccountsLifecycleObserver(observer: AccountsLifecycleObserverImpl): AccountsLifecycleObserver {
        return observer
    }
}