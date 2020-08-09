package com.androidexamples.genericrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

open class GenericRecyclerViewAdapter<T> :RecyclerView.Adapter<GenericViewHolder<T>>() {

     val items=ArrayList<T>()
     var itemClick:((T)->Unit)?=null

     fun addItems(items:ArrayList<T>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T> {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(viewType,parent,false)
        return GenericViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: GenericViewHolder<T>, position: Int) {
       holder.onBind(items[position])
    }

}
open class GenericViewHolder<T>(itemView:View):RecyclerView.ViewHolder(itemView),
    BindRecyclerViewHolder<T> {

    override fun onBind(item: T) {}
}
