package com.example.learnviewmodel.notes

import com.example.learnviewmodel.models.Note
import javax.inject.Inject

class NoteModel @Inject constructor(){

    fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("pi is not exactly 3.14"),
        Note("A double double is Canadian for coffee two cream two sugar")
    )

}