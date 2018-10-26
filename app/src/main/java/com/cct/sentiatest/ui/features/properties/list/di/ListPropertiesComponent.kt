package com.cct.sentiatest.ui.features.properties.list.di

import com.cct.sentiatest.di.ScreenScope
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesFragment
import dagger.Subcomponent

@ScreenScope
@Subcomponent(modules = [ListPropertiesModule::class])
interface ListPropertiesComponent {
    infix fun inject(fragment: ListPropertiesFragment)
}