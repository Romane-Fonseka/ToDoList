package com.example.todolist

import android.app.Application
import androidx.room.Room

class MyApp : Application() {

    private lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()

        // Initialize Room database instance
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "Task_Mgt"
        ).build()
    }
}
