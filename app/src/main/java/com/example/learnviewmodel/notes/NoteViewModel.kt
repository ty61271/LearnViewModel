package com.example.learnviewmodel.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learnviewmodel.foundations.ApplicationScope
import com.example.learnviewmodel.models.Note
import toothpick.Toothpick
import javax.inject.Inject

class NoteViewModel : ViewModel(), NoteListViewContract {

    @Inject
    lateinit var model: INoteModel

    private val _noteLiveData: MutableLiveData<List<Note>> = MutableLiveData()
    val noteLiveData: LiveData<List<Note>> = _noteLiveData

    init {
        Toothpick.inject(this, ApplicationScope.scope)
        _noteLiveData.postValue(model.getFakeData())
    }

}