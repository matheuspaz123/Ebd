package com.example.ebd.UI.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ebd.R
import com.example.ebd.UI.viewmodel.ChamadaViewModel
import com.example.ebd.data.model.Aluno
import com.example.ebd.databinding.FragmentChamadaClasseBinding
import com.example.ebd.utils.utilFiltarClasses
import kotlinx.android.synthetic.main.fragment_chamada_classe.*

class ChamadaClasseFragment : Fragment() {
    lateinit var binding : FragmentChamadaClasseBinding
    var classee : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChamadaClasseBinding.bind(inflater.inflate(R.layout.fragment_chamada_classe, container, false))
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mViewModel = ViewModelProvider(requireActivity()).get(ChamadaViewModel :: class.java)
        mViewModel.classe.observe(viewLifecycleOwner, Observer {
            classee = it
        })
        mViewModel.listaAluno.observe(viewLifecycleOwner, Observer { itens ->

            val aux = itens.let {
                utilFiltarClasses(classee, it)
            }
            chamada_classe_nome.text = aux[0]?.nome
            chamada_classe_chasse.text = aux[0]?.classe
        })
    }


}