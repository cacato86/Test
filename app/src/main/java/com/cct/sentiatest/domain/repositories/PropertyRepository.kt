package com.cct.sentiatest.domain.repositories

import com.cct.sentiatest.data.net.properties.PropertiesDataSource
import com.cct.sentiatest.domain.models.Property
import com.cct.sentiatest.ui.utils.subscribeOnIO
import io.reactivex.Single
import javax.inject.Inject

class PropertyRepository @Inject constructor(private val propertiesDataSource: PropertiesDataSource) {
    fun getProperties(): Single<List<Property>> = propertiesDataSource.getProperties().subscribeOnIO()
}