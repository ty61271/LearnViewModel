package com.example.learnviewmodel.tasks

import androidx.lifecycle.ViewModel
import com.example.learnviewmodel.models.Task
import com.example.learnviewmodel.models.Todo

class TaskViewModel : ViewModel() {
    fun getFakeData(): MutableList<Task> = mutableListOf(
        Task(
            "Testing one!",
            mutableListOf(
                Todo("Test one!", true),
                Todo("Test two!")
            )
        ),
        Task("Testing two!"),
        Task(
            "Testing three!",
            mutableListOf(
                Todo("Test A!"),
                Todo("Test B!")
            )
        )
    )
}