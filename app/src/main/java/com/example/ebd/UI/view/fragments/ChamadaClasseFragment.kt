package com.example.ebd.UI.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.ebd.R
import com.example.ebd.UI.viewmodel.ChamadaViewModel
import com.example.ebd.databinding.FragmentChamadaClasseBinding
import kotlinx.android.synthetic.main.fragment_chamada_classe.*

class ChamadaClasseFragment : Fragment() {
    lateinit var binding : FragmentChamadaClasseBinding

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
        chamada_classe_nome.text = mViewModel.getListSelectedClasse()[0]?.nome
        chamada_classe_chasse.text = mViewModel.getListSelectedClasse()[0]?.classe
    }


}