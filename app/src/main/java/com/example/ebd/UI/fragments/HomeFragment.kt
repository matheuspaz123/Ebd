package com.example.ebd.UI.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ebd.R
import com.example.ebd.databinding.FragmentHomeBinding
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

val meses = ArrayList<String>()
val dados = ArrayList<BarEntry>()


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.bind(view)

        dadosGrafico()

        val barDataSet = BarDataSet(dados,"Presentes")

        barDataSet.color = resources.getColor(R.color.grafico)


        val datafinal = BarData(barDataSet )
        binding.homeGrafico.data = datafinal
        binding.homeGrafico.axisLeft.isEnabled = false
        binding.homeGrafico.xAxis.isEnabled = false
        binding.homeGrafico.axisRight.isEnabled = false
        binding.homeGrafico.isDoubleTapToZoomEnabled = false
        binding.homeGrafico.animateY(2000)
        // Inflate the layout for this fragment
        return view
    }

    fun dadosGrafico(){
        //para titulo das colunas
        meses.add("Janeiro")
        meses.add("Fevereiro")
        meses.add("Março")
        meses.add("Abril")

        //dados das colunas    (coluna , dados)
        dados.add(BarEntry(0f, 5f))
        dados.add(BarEntry(1f, 8f))
        dados.add(BarEntry(2f, 10f))
        dados.add(BarEntry(3f, 7f))





    }


}