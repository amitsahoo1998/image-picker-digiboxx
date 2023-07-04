package com.example.digiboxx.data.repository

import com.example.digiboxx.data.local.ImageDao
import com.example.digiboxx.data.local.ImageEntity
import com.example.digiboxx.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(private val imageDao: ImageDao) : ImageRepository {
    override suspend fun addImage(image: List<ImageEntity>) = imageDao.insertPhoto(image)

    override fun getAllImage(): Flow<List<ImageEntity>> = imageDao.getAllPhoto()
}