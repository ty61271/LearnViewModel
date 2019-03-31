package com.example.learnviewmodel.tasks


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.learnviewmodel.R
import com.example.learnviewmodel.models.Task
import kotlinx.android.synthetic.main.fragment_task_list.*

class TaskListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager=LinearLayoutManager(context)
        val adater=TaskAdater(mutableListOf(
            Task("Testing one!"),
            Task("Testing two!")
        ))
        recyclerView.adapter=adater
    }

    companion object {
        fun newInstance() =TaskListFragment()
    }
}
