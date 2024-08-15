package com.technical.test.smartpayment.api.dto

import com.technical.test.smartpayment.api.response.PlanetDataResponse
import com.technical.test.smartpayment.api.response.PlanetsResponse
import com.technical.test.smartpayment.model.PlanetData
import com.technical.test.smartpayment.model.PlanetsList

class PlanetsListDTOMapper {
    fun fromPlanetListDTOToPlanetListDomain(planetsListDTO: PlanetsResponse): PlanetsList {
        return PlanetsList(
            planetsListDTO.count,
            planetsListDTO.nextPage,
            planetsListDTO.previousPage,
            fromPlanetListDTOToPlanetListDomain(planetsListDTO.results)
        )
    }

    private fun fromPlanetListDTOToPlanetListDomain(planetsDTO: List<PlanetDataResponse>): List<PlanetData> {
        val planetDTOMapper = PlanetDTOMapper()
        return planetsDTO.map { planetDTOMapper.fromPlanetDTOToPlanetDomain(it) }
    }

}