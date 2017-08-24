package com.rukiasoft.amaristest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by Roll on 24/8/17.
 */
class Account {
    @SerializedName("accountBalanceInCents")
    @Expose
    private val accountBalanceInCents: Int? = null
    @SerializedName("accountCurrency")
    @Expose
    private val accountCurrency: String? = null
    @SerializedName("accountId")
    @Expose
    private val accountId: Int? = null
    @SerializedName("accountName")
    @Expose
    private val accountName: String? = null
    @SerializedName("accountNumber")
    @Expose
    private val accountNumber: String? = null
    @SerializedName("accountType")
    @Expose
    private val accountType: String? = null
    @SerializedName("alias")
    @Expose
    private val alias: String? = null
    @SerializedName("iban")
    @Expose
    private val iban: String? = null
    @SerializedName("isVisible")
    @Expose
    private val isVisible: Boolean? = null
    @SerializedName("linkedAccountId")
    @Expose
    private val linkedAccountId: Int? = null
    @SerializedName("productName")
    @Expose
    private val productName: String? = null
    @SerializedName("productType")
    @Expose
    private val productType: Int? = null
    @SerializedName("savingsTargetReached")
    @Expose
    private val savingsTargetReached: Int? = null
    @SerializedName("targetAmountInCents")
    @Expose
    private val targetAmountInCents: Int? = null


}