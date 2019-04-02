package com.example.learnviewmodel.foundations

import com.example.learnviewmodel.notes.INoteModel
import com.example.learnviewmodel.notes.NoteLocalModel
import com.example.learnviewmodel.tasks.ITaskModel
import com.example.learnviewmodel.tasks.TaskLocalModel
import toothpick.Toothpick
import toothpick.config.Module

object ApplicationScope{
    val scope=Toothpick.openScope(this).apply {
        installModules(ApplicationModul)
    }
}

object ApplicationModul:Module(){
    init {
        bind(INoteModel::class.java).toInstance(NoteLocalModel())
        bind(ITaskModel::class.java).toInstance(TaskLocalModel())
    }
}