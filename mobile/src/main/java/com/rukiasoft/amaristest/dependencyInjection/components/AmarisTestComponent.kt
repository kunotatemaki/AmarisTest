package com.rukiasoft.amaristest.dependencyInjection.components

import com.rukiasoft.amaristest.dependencyInjection.modules.AccountsModule
import com.rukiasoft.amaristest.dependencyInjection.modules.AmarisTestModule
import com.rukiasoft.amaristest.dependencyInjection.subcomponents.AccountsSubcomponent
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Roll on 24/8/17.
 */
@Singleton
@Component(modules = arrayOf(AmarisTestModule::class))
interface AmarisTestComponent {
    fun getAccountsSubcomponent(accountsModule: AccountsModule): AccountsSubcomponent
}