package com.example.apptareas.domain

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {
    // Función que devuelve todas las tareas de la bbdd en una lista mutable
    @Query("SELECT * FROM task_entity")
    suspend fun getAllTasks(): MutableList<TaskEntity>

    // Función que añade una tarea, la que se pasa por parámetro, y devuelve el id insertado.
    // Devuelve Long porque la cantidad de datos guardados puede ser muy alto
    @Insert
    suspend fun addTask(taskEntity: TaskEntity): Long

    // Función que busca tareas por id (debe ser Long)
    @Query("SELECT * FROM task_entity WHERE id like :id")
    suspend fun getTaskById(id: Long): TaskEntity

    // Función que actualiza una tarea
    @Update
    suspend fun updateTask(taskEntity: TaskEntity): Int

    // Función que borra una tarea
    @Delete
    suspend fun deleteTask(taskEntity: TaskEntity): Int

}