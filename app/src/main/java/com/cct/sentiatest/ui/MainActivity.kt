package com.cct.sentiatest.ui

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.cct.sentiatest.R
import com.cct.sentiatest.SentiaApp
import com.cct.sentiatest.di.module.ActivityModule
import com.cct.sentiatest.ui.commons.Router
import com.cct.sentiatest.ui.features.properties.detail.DetailPropertiesActivity
import com.cct.sentiatest.ui.features.properties.detail.DetailPropertiesFragment
import com.cct.sentiatest.ui.features.properties.detail.DetailPropertiesFragment.Companion.ARG_ITEM_ID
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesFragment.OnItemClickedListener
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), OnItemClickedListener {

    @Inject
    lateinit var router: Router

    private var landscape: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SentiaApp.component add ActivityModule(this) inject this
        router.init(supportFragmentManager)

        if (item_detail_container != null) {
            landscape = true
        }
        
        if (savedInstanceState == null) {
            router.addInitialFragment()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState?.putBoolean("BUNDLE", true)
    }

    override fun onPropertySelected(id: String) {
        if (landscape) {
            val detailFragment = DetailPropertiesFragment().apply {
                arguments = generateData(id)
            }
            router.open(detailFragment)
        } else {
            val intent = Intent(this, DetailPropertiesActivity::class.java).apply {
                putExtras(generateData(id))
            }
            startActivity(intent)
            overridePendingTransition(R.anim.entry_animation, R.anim.exit_animation)
        }
    }

    private fun generateData(id: String): Bundle = Bundle().apply { putString(ARG_ITEM_ID, id) }
}