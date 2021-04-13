package com.example.ebd.UI.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ebd.R
import com.example.ebd.databinding.FragmentListaAlunosBinding

class ListaAlunosFragment : Fragment() {

    private lateinit var binding: FragmentListaAlunosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaAlunosBinding.bind(
            inflater.inflate(
                R.layout.fragment_lista_alunos,
                container,
                false
            )
        )



        // Inflate the layout for this fragment
        return binding.root
    }


}