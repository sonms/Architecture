package com.example.makersassignment.data.di

import com.example.makersassignment.data.repositoryimpl.remote.GalleryRepositoryImpl
import com.example.makersassignment.data.repositoryimpl.local.UserRepositoryImpl
import com.example.makersassignment.domain.repository.GalleryRepository
import com.example.makersassignment.domain.repository.local.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository


    @Binds
    @Singleton
    abstract fun bindGalleryRepository(
        galleryRepositoryImpl: GalleryRepositoryImpl
    ): GalleryRepository
}