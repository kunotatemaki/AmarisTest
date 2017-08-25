package com.rukiasoft.amaristest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Roll on 24/8/17.
 */
class Account {
    @SerializedName("accountBalanceInCents")
    @Expose
    val accountBalanceInCents: Int? = null
    @SerializedName("accountCurrency")
    @Expose
    val accountCurrency: String? = null
    @SerializedName("accountId")
    @Expose
    val accountId: Int? = null
    @SerializedName("accountName")
    @Expose
    val accountName: String? = null
    @SerializedName("accountNumber")
    @Expose
    val accountNumber: String? = null
    @SerializedName("accountType")
    @Expose
    val accountType: String? = null
    @SerializedName("alias")
    @Expose
    val alias: String? = null
    @SerializedName("iban")
    @Expose
    val iban: String? = null
    @SerializedName("isVisible")
    @Expose
    val isVisible: Boolean? = null
    @SerializedName("linkedAccountId")
    @Expose
    val linkedAccountId: Int? = null
    @SerializedName("productName")
    @Expose
    val productName: String? = null
    @SerializedName("productType")
    @Expose
    val productType: Int? = null
    @SerializedName("savingsTargetReached")
    @Expose
    val savingsTargetReached: Int? = null
    @SerializedName("targetAmountInCents")
    @Expose
    val targetAmountInCents: Int? = null


}