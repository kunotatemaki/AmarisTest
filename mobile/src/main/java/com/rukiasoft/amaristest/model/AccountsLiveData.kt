package com.rukiasoft.amaristest.model

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistryOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.rukiasoft.amaristest.accountlist.ui.livedataobservers.LivedataObserver
import com.rukiasoft.amaristest.accountlist.ui.mainviews.AccountsView
import javax.inject.Inject


/**
 * Created by Roll on 24/8/17.
 */
class AccountsLiveData @Inject constructor(): MutableLiveData<MutableList<Account>>(), CustomLiveData<MutableList<Account>> {

    override fun setLivedataValue(value: MutableList<Account>) {
        this.value = value
    }

    override fun getLivedataValue(): MutableList<Account>? {
        return this.value
    }

    override fun addObserverToLivedata(view: AccountsView, observer: LivedataObserver) {

        if (view is LifecycleRegistryOwner) {
            this.observe(view as LifecycleOwner,
                    Observer<MutableList<Account>> { accounts -> observer.handleChangesInObservedAccounts(accounts!!) })
        }
    }
}