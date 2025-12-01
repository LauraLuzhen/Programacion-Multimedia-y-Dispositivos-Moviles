package com.example.apptareas.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apptareas.data.TaskRepository
import com.example.apptareas.domain.TaskEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    private val _tasks = MutableStateFlow<List<TaskEntity>>(emptyList())
    val tasks: StateFlow<List<TaskEntity>> = _tasks

    init {
        // ... (resto del código del init y collectTasks igual)
        collectTasks()
    }

    private fun collectTasks() {
        viewModelScope.launch {
            repository.getAllTasks()
                .catch { e ->
                    println("Error collecting tasks: $e")
                }
                .collect { tasksList ->
                    _tasks.value = tasksList
                }
        }
    }

    fun addTask(title: String) {
        if (title.isBlank()) return
        val newTask = TaskEntity(name = title)
        viewModelScope.launch {
            repository.addTask(newTask)
        }
    }

    fun toggleTaskDone(task: TaskEntity) {
        val updatedTask = task.copy(isDone = !task.isDone)
        viewModelScope.launch {
            repository.updateTask(updatedTask)
        }
    }
}