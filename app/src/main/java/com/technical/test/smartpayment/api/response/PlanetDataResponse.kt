package com.technical.test.smartpayment.api.response

import com.squareup.moshi.Json

data class PlanetDataResponse(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "rotation_period") val rotationPeriod: String,
    @field:Json(name = "orbital_period") val orbitalPeriod: String,
    @field:Json(name = "diameter") val diameter: String,
    @field:Json(name = "climate") val climate: String,
    @field:Json(name = "gravity") val gravity: String,
    @field:Json(name = "terrain") val terrain: String,
    @field:Json(name = "surface_water") val surfaceWater: String,
    @field:Json(name = "population") val population: String,
    @field:Json(name = "residents") val residentsUrl: List<String>,
    @field:Json(name = "films") val filmsUrl: List<String>,
    @field:Json(name = "created") val created: String,
    @field:Json(name = "edited") val edited: String,
    @field:Json(name = "url") val url: String,
)