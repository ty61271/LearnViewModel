package com.example.learnviewmodel.tasks

interface TaskListViewContract {
    fun onTodoUpdated(taskIndex: Int, todoIndex: Int, isComplete: Boolean)
}