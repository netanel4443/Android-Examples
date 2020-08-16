package com.androidexamples.examples.recyclerviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidexamples.*
import com.androidexamples.examples.genericrecyclerview.*
import kotlinx.android.synthetic.main.recyclerview_another_cell_layout.view.*
import kotlinx.android.synthetic.main.recyclerview_cell_design.view.*

class SomeRecyclerViewAdapter:
    GenericRecyclerViewAdapter<CommonType>() {

    private val IntType=0
    private val StringType=1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<CommonType> {
       val inflater=LayoutInflater.from(parent.context)
       return if (viewType==IntType){
            val view=inflater.inflate(R.layout.recyclerview_cell_design,parent,false)
              SomeViewHolder(view) as GenericViewHolder<CommonType>
        }
        else{
           val view=inflater.inflate(R.layout.recyclerview_another_cell_layout,parent,false)
            AnotherViewHolder(view) as GenericViewHolder<CommonType>
       }
    }

    override fun getItemViewType(position: Int): Int {
        if (items[position] is SomeClassInt){
            return IntType
        }
        else
            return StringType
    }

    inner class AnotherViewHolder(itemView: View):
        GenericViewHolder<SomeClassString>(itemView){
        private val textView = itemView.textViewAnotherCellDesign

        override fun onBind(item: SomeClassString) {
            textView.text=item.someString
        }
    }

    inner class SomeViewHolder(itemView: View):
        GenericViewHolder<SomeClassInt>(itemView){
        private val textView = itemView.textViewCellDesign

        init {
            textView.setOnClickListener {
                itemClick?.invoke(items[adapterPosition])
            }
        }

        override fun onBind(item: SomeClassInt) {
            textView.text=item.someInt.toString()
        }
    }
}