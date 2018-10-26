package com.cct.sentiatest.di

import com.cct.sentiatest.di.module.ApplicationModule
import com.cct.sentiatest.di.module.NetworkModule
import com.cct.sentiatest.ui.features.properties.list.di.ListPropertiesComponent
import com.cct.sentiatest.ui.features.properties.list.di.ListPropertiesModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {
    infix fun add(module: ListPropertiesModule): ListPropertiesComponent
}