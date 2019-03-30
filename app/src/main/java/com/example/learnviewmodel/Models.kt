package com.example.learnviewmodel

data class Task(
    var title: String,
    val todos: MutableList<Todo>?= mutableListOf(),
    var tag: Tag?=null
)

data class Todo(
    var description: String,
    var isComplete: Boolean
)

class Note(
    var description: String,
    var tag: Tag?=null
)

data class Tag(
    val name: String,
    val colourResId: Int
)

