package com.technical.test.smartpayment.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.technical.test.smartpayment.room.entity.UserEntityDB
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {
    @Query("SELECT * FROM user ORDER BY id ASC")
    fun getAllUser(): Flow<List<UserEntityDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(vararg userEntityDB: UserEntityDB)

    @Delete
    fun deleteUser(userEntityDB: UserEntityDB)

    @Query("DELETE FROM user")
    fun deleteAllTable()
}