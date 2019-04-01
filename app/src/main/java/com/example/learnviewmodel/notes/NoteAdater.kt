package com.example.learnviewmodel.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learnviewmodel.R
import com.example.learnviewmodel.foundations.BaseRecyclerAdater
import com.example.learnviewmodel.models.Note
import com.example.learnviewmodel.navigation.NavigationActivity
import com.example.learnviewmodel.views.NoteView
import kotlinx.android.synthetic.main.view_add_button.view.*

class NoteAdater(
    notes: MutableList<Note> = mutableListOf(),
    val touchActionDelegate: NotesListFragment.TouchActionDelegate
) : BaseRecyclerAdater<Note>(notes) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if (viewType == TYPE_ADD_BUTTON) {
            AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false))
        } else {
            NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))
        }

    class NoteViewHolder(view: View) : BaseViewHolder<Note>(view) {
        override fun onBind(data: Note, listIndex: Int) {
            (view as NoteView).initView(data)
        }
    }

    inner class AddButtonViewHolder(view: View) : BaseRecyclerAdater.AddButtonViewHolder(view) {
        override fun onBind(data: Unit, listIndex: Int) {
            view.buttonText.text = view.context.getString(R.string.add_button_note)
            view.setOnClickListener {
                touchActionDelegate.onAddButtonClicked(NavigationActivity.FRAGMENT_VALUE_NOTE)
            }
        }
    }
}