package com.example.apptareas.data

import com.example.apptareas.domain.TaskDao
import com.example.apptareas.domain.TaskEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TaskRepository(private val taskDao: TaskDao) {

    // Función que devuelve las tareas como un Flow
    // Esto es crucial para Compose: cualquier cambio en la BBDD se emitirá aquí.
    fun getAllTasks(): Flow<List<TaskEntity>> = flow {
        // En un caso real, Room debería exponer la función como Flow,
        // pero dado el TaskDao proporcionado (que usa MutableList), la emitimos manualmente:
        while (true) {
            emit(taskDao.getAllTasks())
            kotlinx.coroutines.delay(1000) // Emitir cada segundo (SOLO para simulación si Room no usa Flow en el DAO)
            // Para una implementación ideal de Room, la consulta del DAO debería ser:
            // @Query("SELECT * FROM task_entity") fun getAllTasks(): Flow<List<TaskEntity>>
        }
    }

    // Funciones suspend para interactuar con la BBDD
    suspend fun addTask(taskEntity: TaskEntity) {
        taskDao.addTask(taskEntity)
    }

    suspend fun updateTask(taskEntity: TaskEntity) {
        taskDao.updateTask(taskEntity)
    }

    suspend fun deleteTask(taskEntity: TaskEntity) {
        taskDao.deleteTask(taskEntity)
    }
}