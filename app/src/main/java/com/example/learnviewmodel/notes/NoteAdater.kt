package com.example.learnviewmodel.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learnviewmodel.R
import com.example.learnviewmodel.models.Note
import kotlinx.android.synthetic.main.item_note.view.*

class NoteAdater(
    private val notes: MutableList<Note> = mutableListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).onBind(notes[position])
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(note: Note) {
            view.descriptionView.text = note.description
        }
    }
}