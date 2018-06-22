package com.example.olayg.comcastchallenge

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.olayg.comcastchallenge.models.RelatedTopic
import java.util.ArrayList

class RvAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: ArrayList<ViewType> = ArrayList()
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    init {
        delegateAdapters.put(AdapterConstants.SHOWS, ShowsDelegateAdapter())
        delegateAdapters.put(AdapterConstants.RELATED_TOPICS,RelatedTopicDelegateAdapter())
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            delegateAdapters.get(viewType).onCreateViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
            delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, this.items[position])

    override fun getItemViewType(position: Int): Int = this.items[position].getViewType()

    fun addItems(views: List<ViewType>) {
        "addItems".log()
        items.addAll(views)
        notifyItemRangeInserted(0, getLastPosition())
    }


    private fun getLastPosition(): Int = if (items.lastIndex == -1) 0 else items.lastIndex

    fun removeRow(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateItems(views: MutableList<ViewType>) {
        items.clear()
        items.addAll(views)
        notifyItemRangeChanged(0, getLastPosition())
    }
}