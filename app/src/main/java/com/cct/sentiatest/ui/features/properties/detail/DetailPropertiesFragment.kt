package com.cct.sentiatest.ui.features.properties.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cct.sentiatest.R
import com.cct.sentiatest.ui.features.properties.list.ListPropertiesPresenter.Companion.FRAGMENT_ID
import kotlinx.android.synthetic.main.detail_property_layout.*

class DetailPropertiesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.detail_property_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text.text = arguments?.getString(FRAGMENT_ID) ?: getString(R.string.unknow_id)
    }
}
