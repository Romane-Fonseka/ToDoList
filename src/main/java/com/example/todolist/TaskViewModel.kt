package com.example.todolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.Category
import com.example.todolist.Task
import com.example.todolist.TaskCategoryDao
import kotlinx.coroutines.launch

class TaskViewModel(private val taskCategoryDao: TaskCategoryDao) : ViewModel() {

    fun getAllTasks(): LiveData<List<Task>> {
        return taskCategoryDao.getAllTasks()
    }

    fun insertTask(task: Task) {
        // insert operation asynchronously
        viewModelScope.launch {
            taskCategoryDao.insertTask(task)
        }
    }
}
