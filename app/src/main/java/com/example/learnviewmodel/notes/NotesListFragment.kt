package com.example.learnviewmodel.notes


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.learnviewmodel.R
import com.example.learnviewmodel.models.Note
import com.example.learnviewmodel.tasks.TaskListFragment
import kotlinx.android.synthetic.main.fragment_notes_list.*

class NotesListFragment : Fragment() {

    lateinit var touchActionDelegate: NotesListFragment.TouchActionDelegate

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        context?.let {
            if (it is NotesListFragment.TouchActionDelegate) {
                touchActionDelegate = it
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        val adater = NoteAdater(
            mutableListOf(
                Note("pi is not exactly 3.14"),
                Note("A double double is Canadian for coffee two cream two sugar")
            ), touchActionDelegate
        )
        recyclerView.adapter = adater
    }

    companion object {
        fun newInstance() = NotesListFragment()
    }

    interface TouchActionDelegate {
        fun onAddButtonClicked(value: String)
    }
}
