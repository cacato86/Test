package com.cct.sentiatest.ui.features.properties.list.di

import android.support.transition.Slide
import android.support.v4.app.Fragment
import android.view.Gravity
import com.cct.sentiatest.ui.commons.Router
import com.cct.sentiatest.ui.features.properties.detail.DetailPropertiesFragment
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ListPropertiesModule(private val activity: Fragment) {

    companion object {
        const val DETAIL_FRAGMENT = "DetailFragment"
    }

    @Provides
    fun providesRouter(): Router {
        val router = Router()
        router.init(activity.fragmentManager!!)
        return router
    }

    @Provides
    @Named(DETAIL_FRAGMENT)
    fun provideDetailFragment(): Fragment {
        val detailPropertiesFragment = DetailPropertiesFragment()
        detailPropertiesFragment.enterTransition = Slide(Gravity.RIGHT)
        detailPropertiesFragment.exitTransition = Slide(Gravity.LEFT)
        return detailPropertiesFragment
    }

}