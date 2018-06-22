package com.example.olayg.comcastchallenge

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.olayg.comcastchallenge.models.RelatedTopic
import kotlinx.android.synthetic.main.related_topic_list.view.*

class RelatedTopicDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
            RelatedTopicViewHolder(parent.inflate(R.layout.related_topic_list))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) =
            (holder as RelatedTopicViewHolder).bind(item as RelatedTopic)

    class RelatedTopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(topic: RelatedTopic) = with(itemView) {
            val parsedString = topic.text?.split("-")
            tvTitle.text = parsedString?.get(0) ?: "Name"
        }
    }

}
