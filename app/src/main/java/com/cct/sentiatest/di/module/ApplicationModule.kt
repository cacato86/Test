package com.cct.sentiatest.di.module

import android.content.Context
import android.content.SharedPreferences
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.cct.sentiatest.data.bd.SharedPreferencesDataSource
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
open class ApplicationModule(private val context: Context) {

    companion object {
        private const val SHARED_PREFERENCES: String = "SharedPreferences"
    }

    @Provides
    @Singleton
    fun providesGlide(): RequestManager = Glide.with(context)

    @Provides
    @Singleton
    fun providesContext(): Context = context

    @Provides
    @Singleton
    fun providesGson(): Gson = Gson()

    @Provides
    @Singleton
    open fun providesSharedPreferences(context: Context): SharedPreferences =
            context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)

    @Provides
    @Singleton
    open fun providesSharedPreferencesDS(preferences: SharedPreferences, gson: Gson)
            : SharedPreferencesDataSource = SharedPreferencesDataSource(preferences, gson)
}