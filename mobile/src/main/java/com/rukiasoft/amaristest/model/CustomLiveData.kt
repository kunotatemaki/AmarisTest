package com.rukiasoft.amaristest.model

import com.rukiasoft.amaristest.accountlist.ui.livedataobservers.LivedataObserver
import com.rukiasoft.amaristest.accountlist.ui.mainviews.AccountsView


/**
 * Created by Roll on 24/8/17.
 */
interface CustomLiveData<T> {

    fun setLivedataValue(value: T)

    fun getLivedataValue(): T?

    fun addObserverToLivedata(view: AccountsView, observer: LivedataObserver)

}