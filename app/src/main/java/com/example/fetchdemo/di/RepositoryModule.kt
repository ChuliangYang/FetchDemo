package com.example.fetchdemo.di

import com.example.fetchdemo.data.repository.HiringListRepository
import com.example.fetchdemo.data.repository.HiringListRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindHiringListRepository(
        impl: HiringListRepositoryImpl
    ): HiringListRepository
}