package com.example.learnviewmodel.notes

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learnviewmodel.models.Note
import kotlinx.android.synthetic.main.fragment_notes_list.*
import kotlinx.android.synthetic.main.fragment_notes_list.view.*

class NoteListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context) {

    private lateinit var adater: NoteAdater
    private lateinit var touchActionDelegate: NotesListFragment.TouchActionDelegate
    private lateinit var dataActionDelegate: NoteListViewContract
    fun initView(taDelegate: NotesListFragment.TouchActionDelegate, daDelegate: NoteListViewContract) {


        setUpDelegates(taDelegate, daDelegate)
        setUpView()
    }

    private fun setUpDelegates(taDelegate: NotesListFragment.TouchActionDelegate, daDelegate: NoteListViewContract) {
        touchActionDelegate = taDelegate
        dataActionDelegate = daDelegate
    }

    private fun setUpView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        adater = NoteAdater(
            touchActionDelegate = touchActionDelegate
        )
        recyclerView.adapter = adater
    }

    fun updateList(list: List<Note>) {
        adater.updateList(list)
    }
}