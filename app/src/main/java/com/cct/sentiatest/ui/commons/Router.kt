package com.cct.sentiatest.ui.commons

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.cct.sentiatest.R

class Router {

    private lateinit var mFragmentManager: FragmentManager

    fun init(fragmentManager: FragmentManager) {
        mFragmentManager = fragmentManager
    }

    fun open(fragment: Fragment) {
        mFragmentManager.beginTransaction()
                .add(R.id.fragment, fragment)
                .addToBackStack(fragment.toString())
                .commit()
    }
}