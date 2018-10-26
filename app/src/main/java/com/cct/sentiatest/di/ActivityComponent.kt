package com.cct.sentiatest.di

import com.cct.sentiatest.di.module.ActivityModule
import com.cct.sentiatest.ui.MainActivity
import dagger.Subcomponent

@ScreenScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    infix fun inject(activity: MainActivity)
}