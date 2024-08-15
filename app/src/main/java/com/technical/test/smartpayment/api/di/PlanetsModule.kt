package com.technical.test.smartpayment.api.di

import com.technical.test.smartpayment.api.repository.PlanetsRepository
import com.technical.test.smartpayment.api.repository.tasks.PlanetsTasks
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class PlanetsModule {
    @Binds
    abstract fun bindPlanetsTasks(
        planetsRepository: PlanetsRepository
    ): PlanetsTasks
}