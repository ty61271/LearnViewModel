package com.example.learnviewmodel.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learnviewmodel.R
import com.example.learnviewmodel.foundations.BaseRecyclerAdater
import com.example.learnviewmodel.models.Task
import com.example.learnviewmodel.navigation.NavigationActivity
import com.example.learnviewmodel.views.TaskView
import kotlinx.android.synthetic.main.view_add_button.view.*

class TaskAdater(
    taskList: MutableList<Task> = mutableListOf(),
    val touchActionDelegate: TaskListFragment.TouchActionDelegate,
    val dataActionDelegate: TaskListViewContract
) : BaseRecyclerAdater<Task>(taskList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if (viewType == TYPE_INFO)
            TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))
        else
            AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false))

   inner class TaskViewHolder(view: View) : BaseViewHolder<Task>(view) {
        override fun onBind(data: Task, listIndex: Int) {
            (view as TaskView).initView(data) {todoIndex,isChecked->
                dataActionDelegate.onTodoUpdated(listIndex,todoIndex,isChecked)
            }
        }
    }

    inner class AddButtonViewHolder(view: View) : BaseRecyclerAdater.AddButtonViewHolder(view) {
        override fun onBind(data: Unit, listIndex: Int) {
            view.buttonText.text = view.context.getString(R.string.add_button_task)

            view.setOnClickListener {
                touchActionDelegate.onAddButtonClicked(NavigationActivity.FRAGMENT_VALUE_TASK)
            }
        }
    }
}