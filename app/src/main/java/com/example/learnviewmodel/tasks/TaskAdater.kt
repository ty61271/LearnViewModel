package com.example.learnviewmodel.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learnviewmodel.R
import com.example.learnviewmodel.models.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskAdater(
    private val taskList: MutableList<Task> = mutableListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))

    override fun getItemCount() = taskList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).onBind(taskList[position])
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(task: Task) {
            view.titleView.text=task.title
        }
    }
}