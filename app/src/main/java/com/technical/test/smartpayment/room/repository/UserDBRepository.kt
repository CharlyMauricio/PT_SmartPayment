package com.technical.test.smartpayment.room.repository

import com.technical.test.smartpayment.room.dao.UserDAO
import com.technical.test.smartpayment.room.entity.UserEntityDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserDBRepository
@Inject
constructor(
    private val userDAO: UserDAO,
) {

    fun getUserListDB(): Flow<List<UserEntityDB>> {
        return userDAO.getAllUser()
    }

    suspend fun insertUserDB(userEntityDB: UserEntityDB) {
        withContext(Dispatchers.IO) {
            userDAO.insertUser(userEntityDB)
        }
    }

    suspend fun deleteAllUser() {
        withContext(Dispatchers.IO) {
            userDAO.deleteAllTable()
        }
    }
}