package com.androidexamples.examples.recyclerviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidexamples.R
import kotlinx.android.synthetic.main.recyclerview_cell_design.view.*

class SimpleRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items=ArrayList<Int>()

     fun setItems(items:ArrayList<Int>){
        this.items.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.recyclerview_cell_design,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            holder.textView.text=items[position].toString()
        }
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView=itemView.textViewCellDesign
    }
}