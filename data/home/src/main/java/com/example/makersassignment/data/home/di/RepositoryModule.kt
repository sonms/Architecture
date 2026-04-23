package com.example.makersassignment.data.home.di
import com.example.makersassignment.data.home.repositoryimpl.GalleryRepositoryImpl
import com.example.makersassignment.domain.home.repository.GalleryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindGalleryRepository(
        impl: GalleryRepositoryImpl
    ): GalleryRepository
}
