package com.example.tasks_project.ui.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tasks_project.data.PreferencesManager
import com.example.tasks_project.data.SortOrder
import com.example.tasks_project.data.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel // Add this import statement
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel // Add this annotation
class TasksViewModel @Inject constructor(private val taskDao: TaskDao,
    private val preferencesManager: PreferencesManager
) : ViewModel() {


    val searchQuery = MutableStateFlow("")

    val preferencesFlow = preferencesManager.preferencesFlow

    private val tasksFlow = combine(
        searchQuery,
        preferencesFlow
    ) { query, filterPreferences ->
        Pair(query, filterPreferences)
    }.flatMapLatest { (query, filterPreferences) ->
        taskDao.getTasks(query, filterPreferences.sortOrder, filterPreferences.hideCompleted)
    }

    fun onSortOrderSelected(sortOrder: SortOrder) = viewModelScope.launch {
        preferencesManager.updateSortOrder(sortOrder)
    }

    fun onHideCompletedClick(hideCompleted: Boolean) = viewModelScope.launch {
        preferencesManager.updateHideCompleted(hideCompleted)
    }

    val tasks = tasksFlow.asLiveData()
}

