package com.example.learnviewmodel.notes

import com.example.learnviewmodel.models.Note

typealias SuccessCallback = (Boolean) -> Unit

interface INoteModel {
    fun addNote(note: Note, callback: SuccessCallback)
    fun updateNote(note: Note, callback: SuccessCallback)
    fun deleteNote(note: Note, callback: SuccessCallback)
    fun retrieveNote(): List<Note>

    fun getFakeData(): MutableList<Note>
}