package com.surya.sample.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.surya.sample.databinding.InventoryBinding
import com.surya.sample.ui.home.InventoryData

class Inventory(val list:ArrayList<InventoryData>):RecyclerView.Adapter<Inventory.Holder>() {
    class Holder(inven:InventoryBinding):RecyclerView.ViewHolder(inven.root) {
        val v:InventoryBinding=inven
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view=InventoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)


        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.v.main.setBackgroundResource(list[position].drawable)
        holder.v.ivIcon.setImageResource(list[position].icon)
        holder.v.tvCount.text=list[position].counting
        holder.v.tvtitle.text=list[position].title

    }

    override fun getItemCount(): Int {
        return list.size
    }
}