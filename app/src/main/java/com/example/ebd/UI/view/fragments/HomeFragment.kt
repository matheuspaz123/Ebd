package com.example.ebd.UI.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.ebd.R
import com.example.ebd.databinding.FragmentHomeBinding
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

val dadosList = ArrayList<BarEntry>()


class HomeFragment : Fragment(), View.OnClickListener {

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
        criarGrafico()
        iniciarListeners()


        // Inflate the layout for this fragment
        return binding.root
    }

    //iniciando setListeners
    private fun iniciarListeners() {
        binding.homeCvMatricular.setOnClickListener(this)
        binding.homeCvLista.setOnClickListener(this)
        binding.homeCvChamada.setOnClickListener(this)


    }


    // criar grafico
    private fun criarGrafico() {
        dadosGrafico()

        val barDataSet = BarDataSet(dadosList, "Presentes")

        barDataSet.color = resources.getColor(R.color.grafico)


        val datafinal = BarData(barDataSet)
        binding.homeGrafico.data = datafinal
        binding.homeGrafico.axisLeft.isEnabled = false
        binding.homeGrafico.xAxis.isEnabled = false
        binding.homeGrafico.axisRight.isEnabled = false
        binding.homeGrafico.description.text = "Ano: 2021"
        binding.homeGrafico.isDoubleTapToZoomEnabled = false
        binding.homeGrafico.animateY(2000)


    }

    //dados do grafico
    private fun dadosGrafico() {
        //dados das colunas    (coluna , dados)
        dadosList.add(BarEntry(0f, 5f))
        dadosList.add(BarEntry(1f, 8f))
        dadosList.add(BarEntry(2f, 10f))
        dadosList.add(BarEntry(3f, 7f))


    }

    override fun onClick(v: View?) {

        val navOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.slide_in_left)
            .setExitAnim(R.anim.slide_out_right)
            .build()

        when (v?.id) {
            R.id.home_cv_matricular -> findNavController().navigate(
                R.id.action_homeFragment_to_matriculaFragment,
                null,
                navOptions
            )

            R.id.home_cv_lista -> findNavController().navigate(
                R.id.action_homeFragment_to_listaAlunosFragment,
                null,
                navOptions
            )

            R.id.home_cv_chamada -> findNavController().navigate(
                R.id.action_homeFragment_to_chamadaFragment,
                null,
                navOptions
            )


        }

    }


}