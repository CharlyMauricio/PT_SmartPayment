package com.technical.test.smartpayment.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.technical.test.smartpayment.room.dao.UserDAO
import com.technical.test.smartpayment.room.entity.UserEntityDB

@Database(
    entities = [
        UserEntityDB::class
    ], version = 1
)
abstract class DataBase : RoomDatabase() {

    abstract fun userDAO(): UserDAO

}