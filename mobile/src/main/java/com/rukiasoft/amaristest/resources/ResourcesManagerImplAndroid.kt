package com.rukiasoft.amaristest.resources

import android.content.Context
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.rukiasoft.amaristest.model.Account
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

    override fun loadAccounts(): List<Account> {
        log.d(this, "leo las cuentas desde la clase resources")
        val jsonString = loadJSONFromAsset()
        return getAccountsFromJSON(jsonString)
    }

    private fun loadJSONFromAsset(): String? {
        val json: String?
        try {
            val jsonAccounts = context.assets.open("accounts.json")
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

    private fun getAccountsFromJSON(string: String?): MutableList<Account>{

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