package com.example.learnviewmodel.tasks

import com.example.learnviewmodel.models.Task

typealias SuccessCallback = (Boolean) -> Unit

interface ITaskModel {
    fun addTask(task: Task, callback: SuccessCallback)
    fun updateTask(task: Task, callback: SuccessCallback)
    fun deleteTask(task: Task, callback: SuccessCallback)
    fun retrieveTask(): List<Task>

    fun getFakeData():MutableList<Task>
}