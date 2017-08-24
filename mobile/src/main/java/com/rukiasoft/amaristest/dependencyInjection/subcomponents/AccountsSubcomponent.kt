package com.rukiasoft.amaristest.dependencyInjection.subcomponents

import com.rukiasoft.amaristest.accountlist.ui.mainviews.MainActivity
import com.rukiasoft.amaristest.dependencyInjection.modules.AccountsModule
import com.rukiasoft.amaristest.dependencyInjection.scopes.CustomScopes
import dagger.Subcomponent

/**
 * Created by Roll on 24/8/17.
 */
@CustomScopes.ActivityScope
@Subcomponent(modules = arrayOf(AccountsModule::class))
interface AccountsSubcomponent {
    fun inject(activity: MainActivity)
}