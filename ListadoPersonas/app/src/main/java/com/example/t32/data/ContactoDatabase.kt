package com.example.t32.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.t32.domain.dao.ContactoDao
import com.example.t32.domain.entities.ContactoEntity

@Database(entities = [ContactoEntity::class], version = 1)
abstract class TasksDatabase : RoomDatabase() {
    abstract fun taskDao(): ContactoDao
}
