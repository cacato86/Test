package com.cct.sentiatest.domain.models

data class Property(val area: String, val imageUrls: List<String>, val bedrooms: Int, val bathrooms: Int,
                    val carSpaces: Int, val price: String, val currency: String, val isPremium: Boolean,
                    val address: String, val address2: String, val suburb: String, val state: String,
                    val ownerName: String, val ownerLastName: String, val ownerImage: String,
                    val description: String)