package com.cct.sentiatest.di

import com.cct.sentiatest.di.module.ActivityModule
import com.cct.sentiatest.di.module.ApplicationModule
import com.cct.sentiatest.di.module.NetworkModule
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesFragment
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {
    infix fun add(module: ActivityModule): ActivityComponent
    infix fun inject(listPropertiesFragment: ListPropertiesFragment)
}