package com.example.olayg.comcastchallenge

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.olayg.comcastchallenge.models.Shows

class ShowsDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
            ShowsViewHolder(parent.inflate(1))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) =
            (holder as ShowsViewHolder).bind(item as Shows)

    class ShowsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(shows: Shows) = with(itemView) {}
    }

}
