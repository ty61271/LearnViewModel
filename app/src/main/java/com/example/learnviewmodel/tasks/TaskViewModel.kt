package com.example.learnviewmodel.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learnviewmodel.models.Task
import com.example.learnviewmodel.models.Todo

class TaskViewModel : ViewModel(), TaskListViewContract {

    private val _taskListLiveData: MutableLiveData<MutableList<Task>> = MutableLiveData()
    val taskListLiveData: LiveData<MutableList<Task>> = _taskListLiveData

    init {
        _taskListLiveData.postValue(getFakeData())
    }

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

    override fun onTodoUpdated(taskIndex: Int, todoIndex: Int, isComplete: Boolean) {
        _taskListLiveData.value?.get(taskIndex)?.todos?.get(todoIndex)?.isComplete = isComplete
    }
}