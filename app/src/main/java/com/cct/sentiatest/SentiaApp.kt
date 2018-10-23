package com.cct.sentiatest

import android.app.Application
import com.cct.sentiatest.di.ApplicationComponent
import com.cct.sentiatest.di.DaggerApplicationComponent
import com.cct.sentiatest.di.module.ApplicationModule

class SentiaApp : Application(){

    companion object {
        lateinit var component: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}