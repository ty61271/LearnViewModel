package com.example.learnviewmodel.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learnviewmodel.R
import com.example.learnviewmodel.foundations.BaseRecyclerAdater
import com.example.learnviewmodel.models.Task
import com.example.learnviewmodel.views.TaskView

class TaskAdater(
    taskList: MutableList<Task> = mutableListOf()
) : BaseRecyclerAdater<Task>(taskList) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))

    class ViewHolder(view: View) : BaseViewHolder<Task>(view) {
        override fun onBind(data: Task) {
            (view as TaskView).initView(data)
        }
    }
}