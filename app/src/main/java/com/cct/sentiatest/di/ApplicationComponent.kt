package com.cct.sentiatest.di

import com.cct.sentiatest.di.module.ApplicationModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidInjectionModule::class), ApplicationModule::class])
interface ApplicationComponent {

}