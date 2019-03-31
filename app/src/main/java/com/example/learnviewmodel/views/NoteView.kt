package com.example.learnviewmodel.views

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.learnviewmodel.models.Note
import kotlinx.android.synthetic.main.view_todo.view.*

class NoteView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {
    fun initView(note: Note) {
        descriptionView.text = note.description
    }
}