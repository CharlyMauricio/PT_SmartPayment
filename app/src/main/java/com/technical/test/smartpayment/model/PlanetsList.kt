package com.technical.test.smartpayment.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlanetsList(
    val count: Int,
    val nextUrl: String,
    val previousUrl: String?,
    val resultsPlanets: List<PlanetData>,
) : Parcelable