package com.surya.sample.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.surya.sample.databinding.SheqViewBinding

class SHEQAdapter(val list:ArrayList<SheqData>):RecyclerView.Adapter<SHEQAdapter.Holder>() {
    class Holder(binding:SheqViewBinding):RecyclerView.ViewHolder(binding.root) {
        val v=binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view=SheqViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)


        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
       if (list[position].title.isNotEmpty()){
           holder.v.tvtitle.visibility=View.VISIBLE
           holder.v.llsecondpart.visibility=View.VISIBLE
           holder.v.tvtitle2.visibility=View.VISIBLE
       }
        else{
           holder.v.tvtitle.visibility=View.GONE
           holder.v.llsecondpart.visibility=View.GONE
           holder.v.tvtitle2.visibility=View.GONE
       }

        if (list[position].window.isNotEmpty()){
            holder.v.llWindow.visibility=View.VISIBLE
        }
        else{
            holder.v.llWindow.visibility=View.GONE
        }

        holder.v.data=list[position]




    }

    override fun getItemCount(): Int {
        return list.size
    }
}