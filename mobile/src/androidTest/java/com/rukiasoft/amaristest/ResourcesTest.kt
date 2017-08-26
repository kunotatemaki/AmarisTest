package com.rukiasoft.amaristest

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.rukiasoft.amaristest.resources.ResourcesManagerImplAndroid
import com.rukiasoft.amaristest.test.R
import com.rukiasoft.amaristest.utils.AmarisConstants
import com.rukiasoft.amaristest.utils.logger.AndroidLogHelperImpl
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Created by Roll on 26/8/17.
 */
@RunWith(AndroidJUnit4::class)
class ResourcesTest {

    lateinit var context: Context
    val log: LoggerHelper = AndroidLogHelperImpl()
    lateinit var resources: ResourcesManagerImplAndroid

    @Before
    fun setUp(){
        context = InstrumentationRegistry.getContext()
        resources = ResourcesManagerImplAndroid(log, context)
    }

    @Test
    fun checkIfLoadFileFromAssets(){
        val json: String? = resources.loadJSONFromAsset(AmarisConstants.ACCOUNTS_FILE_NAME_TEST)
        assertTrue(json!!.contains("\"accounts\""))
    }

    @Test
    fun checkIfParseAccountFromJson(){
        val string: String = "{\n" +
                "  \"accounts\" : [{\n" +
                "    \"accountBalanceInCents\": 985000,\n" +
                "    \"accountCurrency\": \"EUR\",\n" +
                "    \"accountId\": 748757694,\n" +
                "    \"accountName\": \"Hr P L G N StellingTD\",\n" +
                "    \"accountNumber\": 748757694,\n" +
                "    \"accountType\": \"PAYMENT\",\n" +
                "    \"alias\": \"\",\n" +
                "    \"isVisible\": true,\n" +
                "    \"iban\": \"NL23INGB0748757694\"\n" +
                "},\n" +
                "{\n" +
                "  \"accountBalanceInCents\": 1000000,\n" +
                "  \"accountCurrency\" : \"EUR\",\n" +
                "  \"accountId\" : 700000027559,\n" +
                "  \"accountName\" : \",\",\n" +
                "  \"accountNumber\" : 748757732,\n" +
                "  \"accountType\" : \"PAYMENT\",\n" +
                "  \"alias\" : \"\",\n" +
                "  \"isVisible\" : false,\n" +
                "  \"iban\" : \"NL88INGB0748757732\"\n" +
                "},\n" +
                "{\n" +
                "  \"accountBalanceInCents\" : 15000,\n" +
                "  \"accountCurrency\" : \"EUR\",\n" +
                "  \"accountId\" : 700000027559,\n" +
                "  \"accountName\" : \"\",\n" +
                "  \"accountNumber\" : \"H 177-27066\",\n" +
                "  \"accountType\" : \"SAVING\",\n" +
                "  \"alias\" : \"G\\\\UfffdLSAVINGSdiacrits\",\n" +
                "  \"iban\" : \"\",\n" +
                "  \"isVisible\" : true,\n" +
                "  \"linkedAccountId\" : 748757694,\n" +
                "  \"productName\" : \"Oranje Spaarrekening\",\n" +
                "  \"productType\" : 1000,\n" +
                "  \"savingsTargetReached\" : 1,\n" +
                "  \"targetAmountInCents\" : 2000\n" +
                "}\n" +
                "  ],\n" +
                "\"failedAccountTypes\" : \"CREDITCARDS\",\n" +
                "\"returnCode\" : \"OK\"\n" +
                "}"
        val accounts = resources.getAccountsFromJSON(string)
        assertTrue(accounts.size == 3)
    }

    @Test
    fun checkIfLoadStringFromStringsFile(){
        val string = resources.getString(R.string.test_string)
        assertTrue(string.equals("This string is used to test resources class"))
    }
}


