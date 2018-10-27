package com.cct.sentiatest.domain.usecases

import com.cct.sentiatest.domain.models.Property
import com.cct.sentiatest.domain.repositories.PropertyRepository
import io.reactivex.Single
import javax.inject.Inject

class ObtainPropertiesUseCase @Inject constructor(private val propertyRepository: PropertyRepository) {
    //I put the premium first (like google in chrome with their premium links) but you can customize
    fun execute(orderFeatures: Boolean = true): Single<List<Property>> = propertyRepository.getProperties()
            .map { propertiesList ->
                if (orderFeatures) {
                    propertiesList.sortedWith(compareByDescending { it.isPremium })
                } else {
                    propertiesList
                }
            }
}