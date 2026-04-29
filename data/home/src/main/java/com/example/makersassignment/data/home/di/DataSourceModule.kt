package com.example.makersassignment.data.home.di

import com.example.makersassignment.data.home.datasource.GalleryDataSource
import com.example.makersassignment.data.home.datasourceimpl.GalleryDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {
    @Binds
    abstract fun bindGalleryDataSource(
        galleryDataSourceImpl: GalleryDataSourceImpl
    ): GalleryDataSource
}
