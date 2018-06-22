package com.example.olayg.comcastchallenge

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.olayg.comcastchallenge.ViewType

interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}