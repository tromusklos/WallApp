package com.lucasmendes.wallapp.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lucasmendes.wallapp.framework.db.dao.WallpapersDao
import com.lucasmendes.wallapp.framework.db.entities.PhotoEntity

@Database(entities = [PhotoEntity::class], version = 1, exportSchema = false)
abstract class WallAppDataBase: RoomDatabase() {
    abstract fun wallpapersDao(): WallpapersDao
}