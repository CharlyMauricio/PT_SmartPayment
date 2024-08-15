package com.technical.test.smartpayment.api.dto

import com.technical.test.smartpayment.api.response.PlanetDataResponse
import com.technical.test.smartpayment.model.PlanetData

class PlanetDTOMapper {
    fun fromPlanetDTOToPlanetDomain(planetDTO: PlanetDataResponse): PlanetData {
        return PlanetData(
            planetDTO.name,
            planetDTO.rotationPeriod,
            planetDTO.orbitalPeriod,
            planetDTO.diameter,
            planetDTO.climate,
            planetDTO.gravity,
            planetDTO.terrain,
            planetDTO.surfaceWater,
            planetDTO.population,
            planetDTO.residentsUrl,
            planetDTO.filmsUrl,
            planetDTO.created,
            planetDTO.edited,
            planetDTO.url,
        )
    }

}