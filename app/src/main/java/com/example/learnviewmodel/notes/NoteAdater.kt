package com.example.learnviewmodel.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learnviewmodel.R
import com.example.learnviewmodel.foundations.BaseRecyclerAdater
import com.example.learnviewmodel.models.Note
import com.example.learnviewmodel.views.NoteView
import kotlinx.android.synthetic.main.item_note.view.*

class NoteAdater(
    notes: MutableList<Note> = mutableListOf()
) : BaseRecyclerAdater<Note>(notes) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))

    class ViewHolder(view: View) : BaseViewHolder<Note>(view) {
        override fun onBind(data: Note) {
            (view as NoteView).initView(data)
        }
    }
}