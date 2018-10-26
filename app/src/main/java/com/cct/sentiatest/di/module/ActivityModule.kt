package com.cct.sentiatest.di.module

import com.cct.sentiatest.ui.MainActivity
import com.cct.sentiatest.ui.commons.Router
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: MainActivity) {

    companion object {
        const val DETAIL_FRAGMENT = "DetailFragment"
    }

    @Provides
    fun providesRouter(): Router {
        val router = Router()
        router.init(activity.supportFragmentManager)
        return router
    }

}