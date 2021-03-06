package com.example.learnviewmodel.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.learnviewmodel.R
import com.example.learnviewmodel.models.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    lateinit var task: Task
    fun initView(task: Task, todoCheckedCallback: (Int, Boolean) -> Unit) {
        this.task = task

        titleView.text = task.title
        task.todos.forEachIndexed { todoIndext, todo ->
            val todoView =
                (LayoutInflater.from(context).inflate(R.layout.view_todo, todoContainer, false) as TodoView).apply {
                    initView(todo) { isCheck ->

                        todoCheckedCallback.invoke(todoIndext, isCheck)
                        if (isTaskComplete()) {
                            this@TaskView.titleView.setStrikeThough()
                        } else {
                            this@TaskView.titleView.removeStrikeThough()
                        }
                    }
                }
            todoContainer.addView(todoView)
        }
    }

    private fun isTaskComplete(): Boolean = task.todos.filter { !it.isComplete }.isEmpty()

}