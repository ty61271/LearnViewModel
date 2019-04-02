package com.example.learnviewmodel.tasks

import com.example.learnviewmodel.models.Task
import com.example.learnviewmodel.models.Todo
import javax.inject.Inject

class TaskLocalModel @Inject constructor() : ITaskModel {

    override fun getFakeData(): MutableList<Task> = mutableListOf(
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

    override fun addTask(task: Task, callback: SuccessCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateTask(task: Task, callback: SuccessCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteTask(task: Task, callback: SuccessCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveTask(): List<Task> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}