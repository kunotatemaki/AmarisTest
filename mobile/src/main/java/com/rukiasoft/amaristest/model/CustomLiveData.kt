package com.rukiasoft.amaristest.model


/**
 * Created by Roll on 24/8/17.
 */
interface CustomLiveData<T> {

    fun setLivedataValue(value: T)

    fun getLivedataValue(): T?

}