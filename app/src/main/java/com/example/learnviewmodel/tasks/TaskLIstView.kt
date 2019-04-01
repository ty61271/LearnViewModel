package com.example.learnviewmodel.tasks

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learnviewmodel.models.Task
import kotlinx.android.synthetic.main.fragment_task_list.view.*

class TaskLIstView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var adater: TaskAdater
    private lateinit var touchActionDelegate: TaskListFragment.TouchActionDelegate
    private lateinit var dataActionDelegate: TaskListViewContract

    fun initView(taDelegate: TaskListFragment.TouchActionDelegate, daDelegate: TaskListViewContract) {
        setDelegates(taDelegate, daDelegate)
        setUpView()
    }

    private fun setDelegates(taDelegate: TaskListFragment.TouchActionDelegate, daDelegate: TaskListViewContract) {
        touchActionDelegate = taDelegate
        dataActionDelegate = daDelegate
    }

    private fun setUpView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        adater = TaskAdater(
            touchActionDelegate = touchActionDelegate,
            dataActionDelegate = dataActionDelegate
        )
        recyclerView.adapter = adater
    }

    fun upDateList(list: List<Task>) {
        adater.updateList(list)
    }
}