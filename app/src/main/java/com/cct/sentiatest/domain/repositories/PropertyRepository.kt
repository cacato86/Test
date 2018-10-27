package com.cct.sentiatest.domain.repositories

import com.cct.sentiatest.data.bd.SharedPreferencesDataSource
import com.cct.sentiatest.data.net.properties.PropertiesDataSource
import com.cct.sentiatest.domain.models.Property
import com.cct.sentiatest.ui.utils.subscribeOnIO
import io.reactivex.Single
import javax.inject.Inject

open class PropertyRepository @Inject constructor(private val propertiesDataSource: PropertiesDataSource,
                                             private val sharedPreferencesDataSource: SharedPreferencesDataSource) {

    fun getProperties(): Single<List<Property>> = propertiesDataSource.getProperties()
            .doAfterSuccess { it -> sharedPreferencesDataSource.savePropertiesList(it) }
            .subscribeOnIO()

    fun restoreProperties(): Single<List<Property>> = sharedPreferencesDataSource.propertiesList.subscribeOnIO()
}