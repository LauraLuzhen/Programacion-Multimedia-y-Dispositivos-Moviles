package com.example.t32.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.t32.domain.entities.ContactoEntity

@Dao
interface ContactoDao {
    @Query("SELECT * FROM task_entity")
    suspend fun getAllTasks(): MutableList<ContactoEntity>

    @Insert
    suspend fun addTask(taskEntity: ContactoEntity): Long

    @Query("SELECT * FROM task_entity WHERE id like :id")
    suspend fun getTaskById(id: Long): ContactoEntity

    @Update
    suspend fun updateTask(taskEntity: ContactoEntity): Int

    @Delete
    suspend fun deleteTask(taskEntity: ContactoEntity): Int

}