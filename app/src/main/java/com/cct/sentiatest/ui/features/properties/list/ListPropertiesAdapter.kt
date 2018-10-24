package com.cct.sentiatest.ui.features.properties.list

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.cct.sentiatest.ui.features.properties.list.item.PropertyNormalItem
import com.cct.sentiatest.ui.features.properties.list.item.PropertyPremiumItem
import com.cct.sentiatest.ui.features.properties.list.item.PropertyVM


class ListPropertiesAdapter(private val openDetailAction: (PropertyVM) -> Unit)
    : RecyclerView.Adapter<ListPropertiesAdapter.MyViewHolder>() {

    companion object {
        private const val TYPE_PREMIUM = 0
        private const val TYPE_NORMAL = 1
    }

    private var collection: MutableList<PropertyVM> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
            when (viewType) {
                TYPE_PREMIUM -> PremiumViewHolder(PropertyPremiumItem(parent.context), openDetailAction)
                else -> NormalViewHolder(PropertyNormalItem(parent.context), openDetailAction)
            }

    override fun getItemViewType(position: Int): Int =
            if (collection[position].isPremium) TYPE_PREMIUM else TYPE_NORMAL

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) = holder.bind(collection[position])

    override fun getItemCount() = collection.size

    fun addAll(collection: List<PropertyVM>) {
        with(this.collection) {
            clear()
            addAll(collection)
        }
        notifyDataSetChanged()
    }

    abstract class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal abstract fun bind(item: PropertyVM)
    }

    class PremiumViewHolder(private val carouselItem: PropertyPremiumItem, private val openDetailAction: (PropertyVM) -> Unit)
        : MyViewHolder(carouselItem) {

        override fun bind(item: PropertyVM) = carouselItem.bind(item, openDetailAction)
    }

    class NormalViewHolder(private val showMoreItem: PropertyNormalItem, private val openDetailAction: (PropertyVM) -> Unit)
        : MyViewHolder(showMoreItem) {

        override fun bind(item: PropertyVM) = showMoreItem.bind(item, openDetailAction)
    }
}