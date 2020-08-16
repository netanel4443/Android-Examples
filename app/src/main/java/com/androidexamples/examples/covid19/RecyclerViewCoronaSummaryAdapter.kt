package com.androidexamples.examples.covid19

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidexamples.R
import kotlinx.android.synthetic.main.recyclerview_corona_cell_design.view.*

class RecyclerViewCoronaSummaryAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items=ArrayList<CoronaCountriesData>()

    fun addItems(items:ArrayList<CoronaCountriesData>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.recyclerview_corona_cell_design,parent,false)
        return CoronaViewHolder(view)
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CoronaViewHolder){
            val countryDetails=items[position]
            holder.textView.text="Country: ${countryDetails.country}\nNew Cases: ${countryDetails.newConfirmed}\nNew Recovered: ${countryDetails.newRecovered}"
        }
    }

    inner class CoronaViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView=itemView.coronaTextView
    }
}