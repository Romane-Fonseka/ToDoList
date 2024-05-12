package com.example.todolist

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todolist.Task
import com.example.todolist.Category

@Dao
interface TaskCategoryDao {
    // Task operations
    @Insert
    suspend fun insertTask(task: Task): Long

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM tasks WHERE id = :taskId")
    fun getTaskById(taskId: Long): LiveData<Task>

    @Query("SELECT * FROM tasks ORDER BY id DESC")
    fun getAllTasks(): LiveData<List<Task>>

    // Category operations
    @Insert
    suspend fun insertCategory(category: Category): Long

    @Update
    suspend fun updateCategory(category: Category)

    @Delete
    suspend fun deleteCategory(category: Category)

    // Combined operations
    @Transaction
    suspend fun insertTaskAndCategory(task: Task, category: Category) {
        val id = insertTask(task)
        category.id = id // Assign taskId to Category
        insertCategory(category)
    }

}
