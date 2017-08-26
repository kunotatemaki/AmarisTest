package com.rukiasoft.amaristest.resources

import android.content.Context
import android.support.annotation.VisibleForTesting
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.rukiasoft.amaristest.model.Account
import com.rukiasoft.amaristest.utils.AmarisConstants
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import java.io.IOException
import javax.inject.Inject


/**
 * Created by Roll on 24/8/17.
 */
class ResourcesManagerImplAndroid @Inject constructor(): ResourcesManager {


    @Inject
    lateinit var log: LoggerHelper

    @Inject
    lateinit var context: Context

    @VisibleForTesting
    constructor(log: LoggerHelper, context: Context) : this() {
        this.log = log
        this.context = context
    }

    override fun getString(resId: Int): String {
        return context.getString(resId)
    }

    override fun loadAccounts(): MutableList<Account> {
        log.d(this, "leo las cuentas desde la clase resources")
        val jsonString = loadJSONFromAsset(AmarisConstants.ACCOUNTS_FILE_NAME)
        return getAccountsFromJSON(jsonString)
    }

    fun loadJSONFromAsset(filename: String): String? {
        val json: String?
        try {
            val jsonAccounts = context.assets.open(filename)
            val size = jsonAccounts.available()
            val buffer = ByteArray(size)
            jsonAccounts.read(buffer)
            jsonAccounts.close()
            json = String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }

    fun getAccountsFromJSON(string: String?): MutableList<Account>{

        val parser: JsonParser = JsonParser()
        val json: JsonObject = parser.parse(string).asJsonObject
        val accounts: MutableList<Account> = arrayListOf()
        json.get("accounts")
                ?.asJsonArray
                ?.mapTo(accounts){
                    log.d(this, "mapeando")
                    Gson().fromJson<Account>(it, Account::class.java)
                }
        return accounts
    }
}