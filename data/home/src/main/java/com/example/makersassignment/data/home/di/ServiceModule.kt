package com.example.makersassignment.data.home.di

import com.example.makersassignment.data.home.service.GalleryService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ServiceModule {
    @Provides
    @Singleton
    fun provideGalleryService(retrofit: Retrofit): GalleryService =
        retrofit.create()
}
