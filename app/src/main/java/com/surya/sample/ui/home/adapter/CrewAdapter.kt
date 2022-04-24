package com.surya.sample.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.surya.sample.databinding.CrewViewBinding

class CrewAdapter(val list: ArrayList<CrewData>):RecyclerView.Adapter<CrewAdapter.Holder>() {
    class Holder(binding:CrewViewBinding):RecyclerView.ViewHolder(binding.root) {
        val v=binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view=CrewViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.v.llCrew.setBackgroundResource(list[position].bg)
        holder.v.tvNo.text=list[position].no
        holder.v.tvTitle.text=list[position].text
        holder.v.ivwarning.setImageResource(list[position].icon)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}