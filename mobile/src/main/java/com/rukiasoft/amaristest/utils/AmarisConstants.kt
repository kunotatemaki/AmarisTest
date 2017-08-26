package com.rukiasoft.amaristest.utils

/**
 * Created by Roll on 24/8/17.
 */
object AmarisConstants {

    enum class Type(val value: Int) {
        ALL(1),
        VISIBLE(2)
    }

    val ACCOUNTS_FILE_NAME: String = "accounts.json"
    val ACCOUNTS_FILE_NAME_TEST: String = "accounts_test.json"

}