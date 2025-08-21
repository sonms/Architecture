package com.example.makersassignment.core.di

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoilModule {
    @Provides
    @Singleton
    fun provideImageLoader(application: Application): ImageLoader {
        return (application as ImageLoaderFactory).newImageLoader()
    }
}