package com.rukiasoft.amaristest.dependencyInjection.modules

import android.content.Context
import com.rukiasoft.amaristest.AmarisApplication
import com.rukiasoft.amaristest.resources.ResourcesManager
import com.rukiasoft.amaristest.resources.ResourcesManagerImplAndroid
import javax.inject.Singleton
import dagger.Provides
import com.rukiasoft.amaristest.utils.logger.AndroidLogHelperImpl
import com.rukiasoft.amaristest.utils.logger.LoggerHelper
import dagger.Module


/**
 * Created by Roll on 24/8/17.
 */
@Module
@Singleton
class AmarisTestModule(private val application: AmarisApplication) {


    @Provides
    fun providesPayconiqApplication(): AmarisApplication {
        return application
    }

    @Provides
    fun providesContext(): Context {
        return application.applicationContext
    }

    @Provides
    fun providesLogHelper(logger: AndroidLogHelperImpl): LoggerHelper {
        return logger
    }

    @Provides
    fun providesResourcesManager(resources: ResourcesManagerImplAndroid): ResourcesManager {
        return resources
    }

}