package com.example.todolist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Date

class NewTaskActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newtask)

        // Initialize views
        editText = findViewById(R.id.edittext)
        saveButton = findViewById(R.id.button_save1)

        // Set up Button click listener to save the new task
        saveButton.setOnClickListener {
            // Get the task name entered by the user
            val taskName = editText.text.toString()

            // Check if the task name is not empty
            if (taskName.isNotEmpty()) {
                // Create a new Task object with the task name
                val newTask = Task(name = taskName, description = "", priority = "", deadline = Date())

                // Insert the new task into the database using Room
                insertTask(newTask)

                // Navigate back to MainActivity
                finish()
            } else {
                // Display an error message if the task name is empty
                showToast("Task name cannot be empty")
            }
        }
    }

    private fun insertTask(task: Task) {
        //database.taskCategoryDao().insertTask(task)
    }


    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}


