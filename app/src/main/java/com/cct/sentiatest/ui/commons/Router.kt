package com.cct.sentiatest.ui.commons

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.cct.sentiatest.R
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesFragment

class Router {

    private lateinit var fragmentManager: FragmentManager

    fun init(fragmentManager: FragmentManager) {
        this.fragmentManager = fragmentManager
    }

    fun addInitialFragment() {
        val listPropertiesFragment = ListPropertiesFragment()
        fragmentManager.beginTransaction()
                .add(R.id.container, listPropertiesFragment, "LIST_FRAGMENT")
                .commit()
    }

    fun open(fragment: Fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.item_detail_container, fragment, fragment::class.java.name)
                .addToBackStack(fragment.toString())
                .commit()
    }
}