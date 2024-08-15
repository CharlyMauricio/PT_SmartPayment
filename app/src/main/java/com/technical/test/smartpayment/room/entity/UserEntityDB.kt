package com.technical.test.smartpayment.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class UserEntityDB(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,

    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "paternal_surname")
    val surnamePaternal: String,
    @ColumnInfo(name = "maternal_surname")
    val surnameMaternal: String,
    @ColumnInfo(name = "birthdate")
    val birthdate: String,
    @ColumnInfo(name = "country")
    val country: String,
)