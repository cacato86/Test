package com.cct.sentiatest.di

import com.cct.sentiatest.di.module.ApplicationModule
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesFragment
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), ApplicationModule::class])
interface ApplicationComponent {
    infix fun inject(listPropertiesFragment: ListPropertiesFragment)
}