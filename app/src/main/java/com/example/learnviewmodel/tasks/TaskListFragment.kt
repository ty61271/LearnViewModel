package com.example.learnviewmodel.tasks


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.learnviewmodel.R

class TaskListFragment : Fragment() {

    lateinit var viewModel: TaskViewModel
    lateinit var containView: TaskLIstView
    lateinit var touchActionDelegate: TouchActionDelegate

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        context?.let {
            if (it is TouchActionDelegate) {
                touchActionDelegate = it
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_list, container, false).apply {
            containView = this as TaskLIstView
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViewModel()
        setContainView()
    }

    private fun setContainView() {
        containView.initView(touchActionDelegate, viewModel)
    }

    private fun bindViewModel() {
        viewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)

        viewModel.taskListLiveData.observe(this, Observer { taskList ->
            containView.upDateList(taskList)
        })
    }

    companion object {
        fun newInstance() = TaskListFragment()
    }

    interface TouchActionDelegate {
        fun onAddButtonClicked(value: String)
    }
}
