package com.rukiasoft.amaristest.accountlist.ui.lifecycleobservers

import com.rukiasoft.amaristest.accountlist.presenters.AccountsPresenter
import com.rukiasoft.amaristest.accountlist.ui.mainviews.AccountsView
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import javax.inject.Inject
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import com.rukiasoft.amaristest.accountlist.ui.livedataobservers.LivedataObserver


/**
 * Created by Roll on 24/8/17.
 */
class AccountsLifecycleObserverImpl @Inject constructor(val mView: AccountsView) : AccountsLifecycleObserver, LifecycleObserver {

    @Inject
    lateinit var presenter: AccountsPresenter

    @Inject
    lateinit var log: LoggerHelper

    init {
        mView.addLifecycleObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun actionInOnCreate() {
        log.d(this, "observer's oncreate")

        //force presenter to observe data (repos and user)
        if (presenter is LivedataObserver) {
            mView.getLiveAccounts().addObserverToLivedata(mView, presenter as LivedataObserver)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun actionInOnResume() {
        presenter.loadAccounts()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun actionInOnDestroy() {
        log.d(this, "observer's ondestroy")
    }
}