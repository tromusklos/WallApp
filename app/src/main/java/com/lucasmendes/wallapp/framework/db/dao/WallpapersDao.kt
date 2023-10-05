package com.lucasmendes.wallapp.framework.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lucasmendes.core.data.DbConstants
import com.lucasmendes.wallapp.framework.db.entities.PhotoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WallpapersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: PhotoEntity)

    @Query("SELECT * FROM ${DbConstants.PHOTO_TABLE_NAME}")
    fun selectAllPhotos(): Flow<List<PhotoEntity>>

    @Delete
    suspend fun delete(entity: PhotoEntity)

    @Query("SELECT * FROM ${DbConstants.PHOTO_TABLE_NAME} ORDER BY RANDOM() LIMIT 1 ")
    suspend fun selectRandomDownloadWallpaper(): PhotoEntity
}