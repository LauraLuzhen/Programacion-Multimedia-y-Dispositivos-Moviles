package com.example.apptareas.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.apptareas.domain.TaskDao
import com.example.apptareas.domain.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class TasksDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
