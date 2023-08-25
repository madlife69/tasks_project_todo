package com.example.tasks_project.ui.tasks

import androidx.lifecycle.ViewModel
import com.example.tasks_project.data.TaskDao

class TasksViewModel @ViewModelInject constructor(private val taskDao: TaskDao) : ViewModel {
}