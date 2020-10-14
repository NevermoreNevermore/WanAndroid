package com.fkw.wan.wan.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.annotations.NotNull
import java.lang.NullPointerException

/**
 * description:  wanAndroid中的RecyclerView的基类Adapter
 *
 * version:      1.0

 * createTime:   2020/10/13 17:12

 * modifyTime:    2020/10/13 17:12

 * @author       fkw
 */
abstract class BaseAdapter<T, VH : BaseHolder<T>> : RecyclerView.Adapter<VH>() {

    var data: List<T> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(getLayoutId(), parent, false)
            ?: throw NullPointerException("View 不能为空")
        return createHolder(view, viewType)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindHolder(data[position], position)
    }

    @NotNull
    @LayoutRes
    abstract fun getLayoutId(): Int

    @NotNull
    abstract fun createHolder(view: View, viewType: Int): VH

}


class Holder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindHolder(bean: T, position: Int) {}



}


abstract class BaseHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bindHolder(bean: T, position: Int)

}