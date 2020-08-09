package com.androidexamples.genericrecyclerview

interface BindRecyclerViewHolder<T> {
    fun onBind(item:T)
}