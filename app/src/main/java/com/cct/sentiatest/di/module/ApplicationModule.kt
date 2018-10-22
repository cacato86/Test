package com.cct.sentiatest.di.module

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class ApplicationModule(private val context: Context) {

    @Provides
    @Singleton
    fun providesGlide(): RequestManager = Glide.with(context)

    @Provides
    fun providesContext(): Context = context
}