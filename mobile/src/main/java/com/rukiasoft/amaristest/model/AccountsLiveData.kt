package com.rukiasoft.amaristest.model

import android.arch.lifecycle.MutableLiveData
import javax.inject.Inject

/**
 * Created by Roll on 24/8/17.
 */
class AccountsLiveData<T> @Inject constructor(): MutableLiveData<T>(), CustomLiveData<T> {

    override fun setLivedataValue(value: T) {
        this.value = value
    }

    override fun getLivedataValue(): T? {
        return this.value
    }


}