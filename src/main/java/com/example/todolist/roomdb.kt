package com.example.todolist

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolist.Task
import com.example.todolist.Category

@Database(entities = [Task::class, Category::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskCategoryDao(): TaskCategoryDao
}
