package com.example.starwars.core.di

import com.example.starwars.core.domain.repositories.StartWarsRepository
import com.example.starwars.core.repositories.StarWarsRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModules {

    @Binds
    abstract fun provideStarWarsRepository(
        starWarsRepoImpl: StarWarsRepoImpl
    ): StartWarsRepository

}