package com.cct.sentiatest.ui.features.properties.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.cct.sentiatest.R

class DetailPropertiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_property_activity_layout)

        if (savedInstanceState == null) {
            val fragment = DetailPropertiesFragment().apply {
                arguments = Bundle().apply {
                    putString(DetailPropertiesFragment.ARG_ITEM_ID,
                            intent.getStringExtra(DetailPropertiesFragment.ARG_ITEM_ID))
                }
            }

            supportFragmentManager.beginTransaction()
                    .add(R.id.item_detail_container, fragment)
                    .commit()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.entry_animation, R.anim.exit_animation)
    }
}
