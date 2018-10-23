package com.cct.sentiatest.ui.features.properties.list.item

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.cct.sentiatest.R
import kotlinx.android.synthetic.main.property_premium_item.view.*

class PropertyPremiumItem @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.property_premium_item, this)
    }

    private fun initView(property: PropertyVM, openDetailAction: (PropertyVM) -> Unit) {
        title.text = property.area
    }

    fun bind(property: PropertyVM, gameClickAction: (PropertyVM) -> Unit) {
        initView(property, gameClickAction)
    }
}