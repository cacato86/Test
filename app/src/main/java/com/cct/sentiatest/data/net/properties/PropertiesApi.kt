package com.cct.sentiatest.data.net.properties

import com.cct.sentiatest.data.net.properties.dto.PropertiesResponse
import io.reactivex.Single
import retrofit2.http.GET

interface PropertiesApi {
    @GET("/properties")
    fun getProperties(): Single<PropertiesResponse>

}