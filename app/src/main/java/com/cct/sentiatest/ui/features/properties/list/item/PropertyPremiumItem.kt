package com.cct.sentiatest.ui.features.properties.list.item

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.cct.sentiatest.R

class PropertyPremiumItem @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.property_premium_item, this)
    }

    private fun initView(game: PropertyVM, openDetailAction: (PropertyVM) -> Unit) {

    }

    fun bind(game: PropertyVM, gameClickAction: (PropertyVM) -> Unit) {
        initView(game, gameClickAction)
    }
}