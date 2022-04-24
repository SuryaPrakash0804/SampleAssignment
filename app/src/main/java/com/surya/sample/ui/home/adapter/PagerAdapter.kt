package com.surya.sample.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.surya.sample.databinding.PagerViewBinding

class PagerAdapter:RecyclerView.Adapter<PagerAdapter.Holder>() {


    class Holder(pager:PagerViewBinding):RecyclerView.ViewHolder(pager.root) {
        val pa:PagerViewBinding=pager
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view=PagerViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)


        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 2
    }


}