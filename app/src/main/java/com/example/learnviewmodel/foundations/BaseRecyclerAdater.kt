package com.example.learnviewmodel.foundations

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.learnviewmodel.tasks.TaskAdater

abstract class BaseRecyclerAdater<T>(
    protected val masterList: MutableList<T> = mutableListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_ADD_BUTTON = 0
        const val TYPE_INFO = 1
    }

    override fun getItemCount() = masterList.size+1

    override fun getItemViewType(position: Int) = if (position == 0) TYPE_ADD_BUTTON else TYPE_INFO

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is AddButtonViewHolder){
            holder.onBind(Unit)
        }else{
            (holder as BaseViewHolder<T>).onBind(masterList[position-1])
        }
    }

    abstract class BaseViewHolder<E>(val view: View) : RecyclerView.ViewHolder(view) {
        abstract fun onBind(data: E)
    }
    abstract  class AddButtonViewHolder(view: View) : BaseViewHolder<Unit>(view)
}