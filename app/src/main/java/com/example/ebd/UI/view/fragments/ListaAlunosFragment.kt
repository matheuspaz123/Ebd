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
import com.example.ebd.data.model.ListaAlunoClasse
import com.example.ebd.databinding.FragmentListaAlunosBinding
import com.google.firebase.database.*
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
        val aa = ArrayList<Aluno?>()
        val dataBase = FirebaseDatabase.getInstance().reference
        val e = dataBase.child("alunos")
        val key = ArrayList<String?>()
            e.addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    aa.clear()
                    key.clear()
                    for (document in snapshot.children){
                        key.add(document.key)
                        aa.add(document.getValue(Aluno::class.java))
                    }
                    adapter.setData(listAluno = aa, keyNo = key)
                }

                override fun onCancelled(error: DatabaseError) {
                }

            })





        // Inflate the layout for this fragment
        return binding.root
    }


}