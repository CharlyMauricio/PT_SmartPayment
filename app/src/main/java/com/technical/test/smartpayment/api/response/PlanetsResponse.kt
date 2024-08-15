package com.technical.test.smartpayment.api.response

import com.squareup.moshi.Json

data class PlanetsResponse(
    @field:Json(name = "count") val count: Int,
    @field:Json(name = "next") val nextPage: String,
    @field:Json(name = "previous") val previousPage: String,
    @field:Json(name = "results") val results: List<PlanetDataResponse>,
)