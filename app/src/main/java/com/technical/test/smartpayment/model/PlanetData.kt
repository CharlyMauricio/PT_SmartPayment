package com.technical.test.smartpayment.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlanetData(
    val name: String,
    val rotationPeriod: String,
    val orbitalPeriod: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    val surfaceWater: String,
    val population: String,
    val residentsUrl: List<String>,
    val filmsUrl: List<String>,
    val created: String,
    val edited: String,
    val url: String,
) : Parcelable