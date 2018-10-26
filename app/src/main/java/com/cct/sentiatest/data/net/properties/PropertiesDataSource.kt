package com.cct.sentiatest.data.net.properties

import com.cct.sentiatest.data.bd.SharedPreferencesDataSource
import com.cct.sentiatest.domain.models.Property
import io.reactivex.Single
import javax.inject.Inject

class PropertiesDataSource @Inject constructor(private val propertiesApi: PropertiesApi,
                                               private val sharedPreferencesDataSource: SharedPreferencesDataSource,
                                               private val mapper: PropertiesMapper) {
    fun getProperties(): Single<List<Property>> =
            propertiesApi.getProperties()
                    .map { mapper.mapProperties(it) }
                    .doAfterSuccess { it -> sharedPreferencesDataSource.savePropertiesList(it) }
}