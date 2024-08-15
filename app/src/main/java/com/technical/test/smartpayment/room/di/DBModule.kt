package com.technical.test.smartpayment.room.di

import android.content.Context
import androidx.room.Room
import com.technical.test.smartpayment.room.DataBase
import com.technical.test.smartpayment.room.dao.UserDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DBModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext appContext: Context): DataBase {
        return Room.databaseBuilder(
            appContext,
            DataBase::class.java,
            "planets_database"
        ).build()
    }

    @Provides
    fun provideUserDAO(appDatabase: DataBase): UserDAO {
        return appDatabase.userDAO()
    }

}