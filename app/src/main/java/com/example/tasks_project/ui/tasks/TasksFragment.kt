package com.example.tasks_project.ui.tasks

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tasks_project.R
@AndroidEntryPoint
class TasksFragment : Fragment(R.layout.fragment_tasks){
    private val viewModel: TasksViewModel by viewModels()
}