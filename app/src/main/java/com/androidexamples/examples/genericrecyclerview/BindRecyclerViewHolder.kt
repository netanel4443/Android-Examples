package com.androidexamples.examples.genericrecyclerview

interface BindRecyclerViewHolder<T> {
    fun onBind(item:T)
}