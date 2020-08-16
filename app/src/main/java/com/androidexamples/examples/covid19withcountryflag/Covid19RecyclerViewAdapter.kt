package com.androidexamples.examples.covid19withcountryflag

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidexamples.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recyclerview_covid19_cell_design.view.*

class Covid19RecyclerViewAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items=ArrayList<CountryDetails>()

     fun addItems(items:ArrayList<CountryDetails>) {
        this.items.addAll(items)
         notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       val inflater=LayoutInflater.from(parent.context)
       val view=inflater.inflate(R.layout.recyclerview_covid19_cell_design,parent,false)
       return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            println("${items[position].countryInfo?.flag}")
            Glide.with(holder.countryImage.context)
                .load(items[position].countryInfo?.flag).into(holder.countryImage)
            val string="country: ${items[position].country}\nactive: ${items[position].active}\ncases: ${items[position].cases}\nrecovered: ${items[position].recovered}\ntests: ${items[position].tests}"
            holder.countryDetailsTextView.text=string
        }
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val countryDetailsTextView=itemView.country_text_view_covid19
        val countryImage=itemView.country_covid19_img
    }
}