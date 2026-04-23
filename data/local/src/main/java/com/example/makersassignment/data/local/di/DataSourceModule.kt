package com.example.makersassignment.data.local.di

import com.example.makersassignment.data.local.datasource.UserPreferencesDataSource
import com.example.makersassignment.data.local.datasourceimpl.UserPreferencesDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindUserPreferencesDataSource(
        userPreferencesDataSourceImpl: UserPreferencesDataSourceImpl
    ): UserPreferencesDataSource
}
