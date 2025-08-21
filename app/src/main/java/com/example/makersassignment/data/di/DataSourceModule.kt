package com.example.makersassignment.data.di

import com.example.makersassignment.data.datasource.local.UserPreferencesDataSource
import com.example.makersassignment.data.datasource.remote.GalleryDataSource
import com.example.makersassignment.data.datasourceimpl.local.UserPreferencesDataSourceImpl
import com.example.makersassignment.data.datasourceimpl.remote.GalleryDataSourceImpl
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

    @Binds
    abstract fun bindGalleryDataSource(
        galleryDataSourceImpl: GalleryDataSourceImpl
    ): GalleryDataSource
}