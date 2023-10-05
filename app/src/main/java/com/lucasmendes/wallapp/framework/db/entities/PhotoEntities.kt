package com.lucasmendes.wallapp.framework.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lucasmendes.core.data.DbConstants
import com.lucasmendes.core.domain.model.PhotoDomain
import com.lucasmendes.core.domain.model.SrcDomain

@Entity(tableName = DbConstants.PHOTO_TABLE_NAME)
data class PhotoEntity(
    @PrimaryKey
    val id: Int,
    val urlPhoto: String,
    val smallPhoto: String,
    val photographer: String,
    val avgColor: String
)
fun List<PhotoEntity>.toPhotoDomain() = map {
    PhotoDomain(
        id = it.id,
        photographer = it.photographer,
        avgColor = it.avgColor,
        srcDomain = SrcDomain(original = it.urlPhoto, small = it.smallPhoto)
    )
}