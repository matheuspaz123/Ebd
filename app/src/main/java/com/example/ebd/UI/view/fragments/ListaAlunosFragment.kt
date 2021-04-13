package com.example.ebd.UI.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ebd.R
import com.example.ebd.UI.adapter.AdapterListaAluno
import com.example.ebd.data.model.Aluno
import com.example.ebd.databinding.FragmentListaAlunosBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class ListaAlunosFragment : Fragment() {

    private lateinit var binding: FragmentListaAlunosBinding
    private val db = Firebase.firestore

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

        val recyclerAlunoLista = binding.listaAlunosRecycler
        val adapter = AdapterListaAluno()
        recyclerAlunoLista.adapter = adapter
        val linearManager = LinearLayoutManager(context)
        linearManager.orientation = LinearLayoutManager.VERTICAL
        recyclerAlunoLista.layoutManager = linearManager

        val a = db.collection("usuarios")
        val aa = ArrayList<Aluno>()
        a.get().addOnSuccessListener {
            val d = it.documents
            for (document in d){
                aa.add(document.toObject(Aluno::class.java)!!)
            }
            adapter.setData(aa)

        }



        // Inflate the layout for this fragment
        return binding.root
    }


}