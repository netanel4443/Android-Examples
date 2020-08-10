package com.androidexamples.exampless.genericrecyclerview

interface BindRecyclerViewHolder<T> {
    fun onBind(item:T)
}