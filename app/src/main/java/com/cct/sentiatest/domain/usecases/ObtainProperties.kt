package com.cct.sentiatest.domain.usecases

import com.cct.sentiatest.domain.repositories.PropertyRepository
import javax.inject.Inject

class ObtainProperties @Inject constructor(private val propertyRepository: PropertyRepository) {
    fun execute() = propertyRepository.getProperties()
            .map { it.sortedWith(compareByDescending { it.isPremium }) }
}