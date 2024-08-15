package com.technical.test.smartpayment.api

import com.technical.test.smartpayment.api.response.PlanetDataResponse
import com.technical.test.smartpayment.api.response.PlanetsResponse
import com.technical.test.smartpayment.api.util.GET_PLANETS
import com.technical.test.smartpayment.model.PlanetsList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET(GET_PLANETS)
    suspend fun getAllListPlanets(
        @Query("page") page: Int
    ): PlanetsResponse

    @GET("$GET_PLANETS/{idPlanet}")
    suspend fun getDataPlanet(
        @Path("idPlanet") idPlanet: String,
    ): PlanetDataResponse
}