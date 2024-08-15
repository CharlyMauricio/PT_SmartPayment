package com.technical.test.smartpayment.api.repository.tasks

import com.technical.test.smartpayment.api.util.ApiResponseStatus
import com.technical.test.smartpayment.model.PlanetData
import com.technical.test.smartpayment.model.PlanetsList

interface PlanetsTasks {

    suspend fun getPlanetsList(page: Int): ApiResponseStatus<PlanetsList>
    suspend fun getPlanetData(idPlanet: String): ApiResponseStatus<PlanetData>

}