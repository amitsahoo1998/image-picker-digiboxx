package com.example.digiboxx.domain.repository

import com.example.digiboxx.data.local.ImageEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Singleton
interface ImageRepository {

    suspend fun addImage(image : List<ImageEntity>)

    fun getAllImage() : Flow<List<ImageEntity>>

}