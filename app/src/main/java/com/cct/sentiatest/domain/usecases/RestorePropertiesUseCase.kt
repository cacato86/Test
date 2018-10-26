package com.cct.sentiatest.domain.usecases

import com.cct.sentiatest.domain.models.Property
import com.cct.sentiatest.domain.repositories.PropertyRepository
import io.reactivex.Single
import javax.inject.Inject

class RestorePropertiesUseCase @Inject constructor(private val propertyRepository: PropertyRepository) {
    fun execute(): Single<List<Property>> = propertyRepository.restoreProperties()
            .map { it.sortedWith(compareByDescending { it.isPremium }) }
}