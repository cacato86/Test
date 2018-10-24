package com.cct.sentiatest.data.net.properties

import com.cct.sentiatest.data.net.properties.dto.PropertiesResponse
import io.reactivex.Single
import javax.inject.Inject

class PropertiesDataSource @Inject constructor(val propertiesApi: PropertiesApi) {
    fun getProperties(): Single<PropertiesResponse> =
            propertiesApi.getProperties()
}