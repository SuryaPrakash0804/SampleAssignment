package com.surya.sample.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

import com.surya.sample.R
import com.surya.sample.databinding.FragmentHomeBinding
import com.surya.sample.ui.home.adapter.*


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var adapter1:PagerAdapter

    private lateinit var inventory:Inventory

    private lateinit var sheqAdapter: SHEQAdapter

    private lateinit var crewAdapter: CrewAdapter

   // private lateinit var pieChart:PieChart



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)



        init()
        return binding.root
    }


    private fun init(){



        binding.rvTop.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        adapter1=PagerAdapter()
        binding.rvTop.adapter=adapter1
        binding.indicator.attachToRecyclerView(binding.rvTop)




        setInventoryView()

        setSHEQ()
        setCrew()

        setPieChart()


    }


    private fun setInventoryView(){
        binding.inventory.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        inventory= Inventory(addInventory())

        binding.inventory.adapter=inventory

    }



    private fun addInventory():ArrayList<InventoryData>{
        val list=ArrayList<InventoryData>()

        list.add(InventoryData(R.drawable.inventorybg1,R.drawable.cogs,"06","Critical spare parts below Min. stack"))

        list.add(InventoryData(R.drawable.inventorybg2,R.drawable.cart,"15","Critical Consumables below Min. stack"))


        list.add(InventoryData(R.drawable.inventorybg3,R.drawable.time2,"12","Consumable To Be Expired"))

        list.add(InventoryData(R.drawable.inventorybg4,R.drawable.warning,"03","Expired Consumables"))

        return list
    }



    private fun setCrew(){
        binding.rvCrew.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        crewAdapter= CrewAdapter(getCrewData())

        binding.rvCrew.adapter=crewAdapter
    }

    private fun getCrewData():ArrayList<CrewData>{
        val list=ArrayList<CrewData>()

        list.add(CrewData(R.drawable.crewbg1,R.drawable.crew_warning,"12","Crew \nDocument Expired"))
        list.add(CrewData(R.drawable.crewbg2,R.drawable.crew_user_check,"10","Pending \nCrew Approvals"))

        return list
    }



    private fun getSHEQData():ArrayList<SheqData>{
        val list=ArrayList<SheqData>()
        list.add(SheqData("","22","07","03","15"))
        list.add(SheqData("","11","05","13","19"))
        list.add(SheqData("","03","03","01","02"))
        list.add(SheqData("not empty","01","02","","15"))

        return list
    }


    private fun setSHEQ(){
        binding.rvSheq.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        sheqAdapter= SHEQAdapter(getSHEQData())

        binding.rvSheq.adapter=sheqAdapter

        binding.indicatorSheq.attachToRecyclerView(binding.rvSheq)

    }



    private fun setPieChart(){
        binding.incedentAccident.setUsePercentValues(true)
        binding.incedentAccident.description?.isEnabled = false
        binding.incedentAccident.isDrawHoleEnabled = false
        binding.incedentAccident.isRotationEnabled = false

        binding.incedentAccident.setDrawEntryLabels(true)
        binding.incedentAccident.setEntryLabelColor(Color.BLACK)
        binding.incedentAccident.setEntryLabelTextSize(12f)

        val entries = java.util.ArrayList<PieEntry>()
        entries.add(PieEntry(30.0f,""))
        entries.add(PieEntry(17.0f ,""))
        entries.add(PieEntry(5.0f,""))
        entries.add(PieEntry(7.0f,""))


        val dataSet = PieDataSet(entries,"")
        val colors = ArrayList<Int>()

        val LIBERTY_COLORS = intArrayOf(
            Color.rgb(228, 63, 242),
            Color.rgb(136, 94, 255),
            Color.rgb(255, 175, 26),
            Color.rgb(23,100,255)

        )
        for (c in LIBERTY_COLORS) colors.add(c)




        dataSet.colors = colors
        val data = PieData(dataSet)
        binding.incedentAccident.data = data
    }


}