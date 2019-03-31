package com.example.learnviewmodel.tasks

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learnviewmodel.R
import com.example.learnviewmodel.foundations.BaseRecyclerAdater
import com.example.learnviewmodel.models.Task
import kotlinx.android.synthetic.main.item_task.view.*
import kotlinx.android.synthetic.main.view_todo.view.*

class TaskAdater(
    taskList: MutableList<Task> = mutableListOf()
) : BaseRecyclerAdater<Task>(taskList) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))

    class ViewHolder(view: View) : BaseViewHolder<Task>(view) {
        override fun onBind(data: Task) {
            view.titleView.text = data.title
            data.todos.forEach { todo ->
                val todoView =
                    LayoutInflater.from(view.context).inflate(R.layout.view_todo, view.todoContainer, false).apply {
                        descriptionView.text = todo.description
                        completeCheckBox.isChecked = todo.isComplete
                        if(todo.isComplete){
                            descriptionView.paintFlags=descriptionView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                        }
                        completeCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
                            if(isChecked){
                                descriptionView.paintFlags=descriptionView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                            }else{
                                descriptionView.paintFlags=descriptionView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                            }
                        }
                    }
                view.todoContainer.addView(todoView)
            }
        }
    }
}