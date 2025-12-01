package com.example.t32.data

import com.example.t32.domain.dao.ContactoDao
import com.example.t32.domain.entities.ContactoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ContactoRepository (private val contactoDao: ContactoDao) {

    fun getAllContactos(): Flow<List<ContactoEntity>> = flow {
        while (true) {
            emit(contactoDao.getAllTasks())
            kotlinx.coroutines.delay(1000)
        }
    }

    suspend fun addTask(taskEntity: ContactoEntity) {
        contactoDao.addTask(taskEntity)
    }

    suspend fun updateTask(taskEntity: ContactoEntity) {
        contactoDao.updateTask(taskEntity)
    }

    suspend fun deleteTask(taskEntity: ContactoEntity) {
        contactoDao.deleteTask(taskEntity)
    }
}