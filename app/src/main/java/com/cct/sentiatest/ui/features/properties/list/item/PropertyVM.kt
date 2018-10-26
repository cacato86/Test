package com.cct.sentiatest.ui.features.properties.list.item

data class PropertyVM(val id: String, val area: String, val bedrooms: String, val bathrooms: String, val carspaces: String,
                      val description: String, val image: String, val price: String, val ownerName: String,
                      val ownerImage: String, val address: String, val isPremium: Boolean)