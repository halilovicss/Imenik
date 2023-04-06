package com.example.imenik.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imenik.databinding.ItemListBinding
import com.example.imenik.model.Imenik

class ImenikAdapter(private val list: List<Imenik>): RecyclerView.Adapter<ImenikAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImenikAdapter.ViewHolder {
        val binding = ItemListBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImenikAdapter.ViewHolder, position: Int) {
       holder.bind(list[position])
    }

    override fun getItemCount(): Int {
       return list.size
    }



class ViewHolder(val binding: ItemListBinding):RecyclerView.ViewHolder(binding.root){
    fun bind (get:Imenik){
   binding.txtPhoneNumber.text = get.phone
    binding.textView2.text = get.name
    }
}


}


