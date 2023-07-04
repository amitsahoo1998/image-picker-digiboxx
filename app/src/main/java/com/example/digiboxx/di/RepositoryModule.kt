package com.example.digiboxx.di

import com.example.digiboxx.data.local.ImageDao
import com.example.digiboxx.data.repository.ImageRepositoryImpl
import com.example.digiboxx.domain.repository.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
class RepositoryModule {

    @ViewModelScoped
    @Provides
    fun provideImageRepository(imageDao: ImageDao) : ImageRepository {
        return ImageRepositoryImpl(imageDao)
    }
}