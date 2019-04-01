package com.example.learnviewmodel.foundations

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdater<T>(
    protected val masterList: MutableList<T> = mutableListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun updateList(list: List<T>) {
        val result=DiffUtil.calculateDiff(DiffUtilCallbackImpl(masterList,list))
        masterList.clear()
        masterList.addAll(list)
        result.dispatchUpdatesTo(this)
    }

    companion object {
        const val TYPE_ADD_BUTTON = 0
        const val TYPE_INFO = 1
    }

    override fun getItemCount() = masterList.size + 1

    override fun getItemViewType(position: Int) = if (position == 0) TYPE_ADD_BUTTON else TYPE_INFO

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AddButtonViewHolder) {
            holder.onBind(Unit, position - 1)
        } else {
            (holder as BaseViewHolder<T>).onBind(masterList[position - 1], position - 1)
        }
    }

    abstract class BaseViewHolder<E>(val view: View) : RecyclerView.ViewHolder(view) {
        abstract fun onBind(data: E, listIndex: Int)
    }

    abstract class AddButtonViewHolder(view: View) : BaseViewHolder<Unit>(view)

    class DiffUtilCallbackImpl<T>(val oldList: List<T>, val newList: List<T>) : DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition] == newList[newItemPosition]

        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition] == newList[newItemPosition]

    }
}