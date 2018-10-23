package com.cct.sentiatest.ui.features.properties.list.item

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.cct.sentiatest.R
import kotlinx.android.synthetic.main.property_normal_item.view.*

class PropertyNormalItem @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.property_normal_item, this)
    }

    private fun initView(property: PropertyVM, openDetailAction: (PropertyVM) -> Unit) {
        title.text = property.area
    }

    fun bind(property: PropertyVM, gameClickAction: (PropertyVM) -> Unit) {
        initView(property, gameClickAction)
    }
}