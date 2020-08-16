package com.androidexamples.examples.pixabayapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidexamples.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.pixabay_image_cell_design.view.*

class PixabayImagesRecyclerViewAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = ArrayList<PixabayWebFormatImages>()

    fun addItems(items:ArrayList<PixabayWebFormatImages>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.pixabay_image_cell_design,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
         return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       if (holder is ViewHolder){
           val url=items[position].webformatImage
           Glide.with(holder.image.context).load(url).into(holder.image)
       }
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val image=itemView.pixabay_webformat_image
    }

}
