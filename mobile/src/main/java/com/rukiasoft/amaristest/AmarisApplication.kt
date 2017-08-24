package com.rukiasoft.amaristest

import android.app.Application
import com.rukiasoft.amaristest.dependencyInjection.components.AmarisTestComponent
import com.rukiasoft.amaristest.dependencyInjection.components.DaggerAmarisTestComponent
import com.rukiasoft.amaristest.dependencyInjection.modules.AmarisTestModule

/**
 * Created by Roll on 24/8/17.
 */
class AmarisApplication: Application() {

    lateinit var mComponent: AmarisTestComponent

    override fun onCreate() {
        super.onCreate()
        mComponent = DaggerAmarisTestComponent
                .builder()
                .amarisTestModule(AmarisTestModule(this))
                .build()
    }
}