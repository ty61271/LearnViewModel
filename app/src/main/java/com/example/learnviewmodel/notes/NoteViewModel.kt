package com.example.learnviewmodel.notes

import androidx.lifecycle.ViewModel
import com.example.learnviewmodel.models.Note

class NoteViewModel : ViewModel() {

    fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("pi is not exactly 3.14"),
        Note("A double double is Canadian for coffee two cream two sugar")
    )
}