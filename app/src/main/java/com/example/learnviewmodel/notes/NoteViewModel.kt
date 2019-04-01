package com.example.learnviewmodel.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learnviewmodel.models.Note

class NoteViewModel : ViewModel() {

    private val _noteLiveData: MutableLiveData<List<Note>> = MutableLiveData()
    val noteLiveData: LiveData<List<Note>> = _noteLiveData

    init {
        _noteLiveData.postValue(getFakeData())
    }
    fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("pi is not exactly 3.14"),
        Note("A double double is Canadian for coffee two cream two sugar")
    )
}