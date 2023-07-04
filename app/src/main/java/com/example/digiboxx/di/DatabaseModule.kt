package com.example.digiboxx.di

import android.app.Application
import com.example.digiboxx.data.local.ImageDao
import com.example.digiboxx.data.local.ImageDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application) : ImageDatabase{
        return ImageDatabase.getInstance(application)
    }

    @Singleton
    @Provides
    fun provideImageDao(imageDatabase: ImageDatabase) : ImageDao {
        return imageDatabase.addImageDao()
    }
}