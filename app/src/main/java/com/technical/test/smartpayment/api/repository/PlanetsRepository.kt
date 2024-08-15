package com.technical.test.smartpayment.api.repository

import com.technical.test.smartpayment.api.util.makeNetworkCall
import com.technical.test.smartpayment.api.ApiService
import com.technical.test.smartpayment.api.dto.PlanetDTOMapper
import com.technical.test.smartpayment.api.dto.PlanetsListDTOMapper
import com.technical.test.smartpayment.api.repository.tasks.PlanetsTasks
import com.technical.test.smartpayment.api.util.ApiResponseStatus
import com.technical.test.smartpayment.model.PlanetData
import com.technical.test.smartpayment.model.PlanetsList
import javax.inject.Inject

class PlanetsRepository
@Inject
constructor(
    private val apiService: ApiService,
) : PlanetsTasks {

    override suspend fun getPlanetsList(
        page: Int
    ): ApiResponseStatus<PlanetsList> = makeNetworkCall {
        val response = apiService.getAllListPlanets(page)
        val planetsListDTOMapper = PlanetsListDTOMapper()
        planetsListDTOMapper.fromPlanetListDTOToPlanetListDomain(response)
    }

    override suspend fun getPlanetData(idPlanet: String): ApiResponseStatus<PlanetData> =
        makeNetworkCall {
            val response = apiService.getDataPlanet(idPlanet)
            val planetDTOMapper = PlanetDTOMapper()
            planetDTOMapper.fromPlanetDTOToPlanetDomain(response)
        }

}