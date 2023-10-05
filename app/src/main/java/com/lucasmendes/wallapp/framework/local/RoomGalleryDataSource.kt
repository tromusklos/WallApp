package com.lucasmendes.wallapp.framework.local

import com.lucasmendes.core.data.repository.dbrepository.GalleryLocalDataSource
import com.lucasmendes.core.domain.model.PhotoDomain
import com.lucasmendes.wallapp.framework.db.dao.WallpapersDao
import com.lucasmendes.wallapp.framework.db.entities.PhotoEntity
import com.lucasmendes.wallapp.framework.db.entities.toPhotoDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RoomGalleryDataSource @Inject constructor (private val dao: WallpapersDao): GalleryLocalDataSource {
    override suspend fun selectWallpaper(): Flow<List<PhotoDomain>> =
        dao.selectAllPhotos().map { it.toPhotoDomain() }

    override suspend fun insert(photoDomain: PhotoDomain) =
        dao.insert(photoDomain.toEntity())

    override suspend fun delete(photoDomain: PhotoDomain) =
        dao.delete(photoDomain.toEntity())

    private fun PhotoDomain.toEntity() =
        PhotoEntity(
            id = this.id ?: 0,
            urlPhoto = this.srcDomain?.original ?: "",
            smallPhoto = this.srcDomain?.small ?: "",
            avgColor = this.avgColor ?: "",
            photographer = this.photographer ?: ""
        )

}