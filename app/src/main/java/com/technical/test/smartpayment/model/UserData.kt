package com.technical.test.smartpayment.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserData(
    val id: Int,
    val name: String,
    val surnamePaternal: String,
    val surnameMaternal: String,
    val birthdate: String,
    val country: String,
) : Parcelable