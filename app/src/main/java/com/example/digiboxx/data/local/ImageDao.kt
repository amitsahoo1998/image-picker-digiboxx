package com.example.digiboxx.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ImageDao {

    @Query("SELECT * FROM ImageEntity")
    fun getAllPhoto():Flow<List<ImageEntity>>

    @Insert
    suspend fun insertPhoto(photo : List<ImageEntity>)

}