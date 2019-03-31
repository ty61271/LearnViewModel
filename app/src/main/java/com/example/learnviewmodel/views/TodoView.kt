package com.example.learnviewmodel.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.learnviewmodel.models.Todo
import kotlinx.android.synthetic.main.view_todo.view.*
import javax.security.auth.callback.Callback

class TodoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    fun initView(todo: Todo,callback: (() -> Unit)?=null) {
        descriptionView.text = todo.description
        completeCheckBox.isChecked = todo.isComplete
        if (todo.isComplete) {
            creatStrikeThough()
        }

        setCheckStateListener(todo,callback)
    }

    fun setCheckStateListener(todo: Todo,callback: (()->Unit)? = null) {
        completeCheckBox.setOnCheckedChangeListener { _, isChecked ->
            todo.isComplete=isChecked
            callback?.invoke()
            if (isChecked) {
                creatStrikeThough()
            } else {
                removeStrikeThough()
            }
        }
    }

    private fun creatStrikeThough() {
        descriptionView.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikeThough() {
        descriptionView.apply {
            paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}
