package com.example.learnviewmodel.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learnviewmodel.models.Note

class NoteViewModel : ViewModel(), NoteListViewContract {

    private val model: NoteModel = NoteModel()

    private val _noteLiveData: MutableLiveData<List<Note>> = MutableLiveData()
    val noteLiveData: LiveData<List<Note>> = _noteLiveData

    init {
        _noteLiveData.postValue(model.getFakeData())
    }

}