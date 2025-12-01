package com.example.apptareas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.room.Room
import com.example.apptareas.data.TaskRepository
import com.example.apptareas.ui.theme.AppTareasTheme
import com.example.apptareas.data.TasksDatabase
import com.example.apptareas.domain.TaskEntity
import com.example.apptareas.ui.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {

    // Necesitamos que el Repositorio sea accesible para crear el ViewModel
    private lateinit var repository: TaskRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicialización de Room Database
        val database = Room.databaseBuilder(
            applicationContext,
            TasksDatabase::class.java,
            "tareas-db"
        ).build()

        // Inicialización del Repositorio
        repository = TaskRepository(database.taskDao())

        enableEdgeToEdge()
        setContent {
            AppTareasTheme {
                Surface(modifier = Modifier.fillMaxSize()) {

                    // --- EVITANDO LA FACTORÍA Y USANDO remember ---
                    // Creamos el ViewModel manualmente y lo "recordamos" en el Composable.
                    // Esto evita la Factoría, pero NO es la práctica recomendada para ViewModels.
                    val viewModel = remember {
                        TaskViewModel(repository)
                    }

                    // Si prefieres crear la instancia fuera de Compose (y no usar remember):
                    // val viewModel = TaskViewModel(repository)

                    Principal(viewModel = viewModel)
                }
            }
        }
    }
}

// ======================================================================
// 3. COMPOSABLES DE LA UI (Necesitas copiar TaskViewModel y TaskRepository)
// ======================================================================

/**
 * Contenedor principal de la aplicación.
 * El navController se omite por no ser funcional aquí.
 */
@Composable
fun Principal(viewModel: TaskViewModel, modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        pideDatos(viewModel)
    }
}

/**
 * Campo de texto de entrada, botón de adición y lista de tareas.
 */
@Composable
fun pideDatos(viewModel: TaskViewModel) {
    var newTaskText by rememberSaveable { mutableStateOf("") }

    // Observar el StateFlow
    val tasksList by viewModel.tasks.collectAsState()

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = newTaskText,
            onValueChange = { newTaskText = it },
            label = { Text("Nueva tarea") },
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Button(
            onClick = {
                viewModel.addTask(newTaskText)
                newTaskText = ""
            },
            enabled = newTaskText.isNotBlank()
        ) {
            Text("+")
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    LazyColumn {
        items(tasksList) { item ->
            filaLista(item = item, viewModel = viewModel)
        }
    }
}

/**
 * Fila individual para mostrar una tarea.
 */
@Composable
fun filaLista(item: TaskEntity, viewModel: TaskViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { viewModel.toggleTaskDone(item) }
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = item.isDone,
            onCheckedChange = {
                viewModel.toggleTaskDone(item)
            }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = item.name,
            style = MaterialTheme.typography.bodyLarge.copy(
                textDecoration = if (item.isDone) TextDecoration.LineThrough else null
            ),
            modifier = Modifier.weight(1f)
        )
    }
    Divider()
}