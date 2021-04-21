package com.example.ebd.UI.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ebd.R
import com.example.ebd.UI.adapter.AdapterListaAluno
import com.example.ebd.data.model.Aluno
import com.example.ebd.databinding.FragmentListaAlunosBinding
import com.google.firebase.database.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_lista_alunos.view.*
import kotlinx.android.synthetic.main.fragment_matricula.view.*
import kotlinx.android.synthetic.main.fragment_matricula.view.matricula_sp_classe

class ListaAlunosFragment : Fragment() {
    private val aa = ArrayList<Aluno?>()
    private var classes = ""
    val key = ArrayList<String?>()
    val keyBack = ArrayList<String?>()
    private val alunoListBack = ArrayList<Aluno?>()
    private var listaClasses = arrayOf(
        "Todos",
        "Jovens",
        "Crianças",
        "Adolecentes",
        "Varões",
        "Irmãs",
        "Novos convertidos"
    )
    var list = ArrayList<Aluno?>()

    private lateinit var binding: FragmentListaAlunosBinding
    private val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(
            R.layout.fragment_lista_alunos,
            container,
            false
        )
        binding = FragmentListaAlunosBinding.bind(view)

        var mArrayAdapterClasse =
            ArrayAdapter(view.context, android.R.layout.simple_spinner_item, listaClasses)
        view.lista_sp_classe.adapter = mArrayAdapterClasse
        var spiner = view.lista_sp_classe





        val recyclerAlunoLista = binding.listaAlunosRecycler
        val adapter = AdapterListaAluno()
        recyclerAlunoLista.adapter = adapter
        val linearManager = LinearLayoutManager(context)
        linearManager.orientation = LinearLayoutManager.VERTICAL
        recyclerAlunoLista.layoutManager = linearManager

        val a = db.collection("usuarios")
        val dataBase = FirebaseDatabase.getInstance().reference
        val e = dataBase.child("alunos")
            e.addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    aa.clear()
                    key.clear()
                    for (document in snapshot.children){
                        key.add(document.key)
                        aa.add(document.getValue(Aluno::class.java))
                    }
                    if (classes != "Todos"){
                        val aux = ArrayList<Aluno?>()
                        val auxKey = ArrayList<String?>()
                        for (i in 0..(aa.size -1)){
                            for (j in 0..(alunoListBack.size -1)){
                                if (aa[i]?.nome == alunoListBack[j]?.nome){
                                    aux.add(alunoListBack[j])
                                    auxKey.add(keyBack[j])
                                }
                            }
                        }
                        adapter.setData(aux, auxKey)
                    }else{
                        adapter.setData(aa, key)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                }

            })

        spiner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                list.clear()
                alunoListBack.clear()
                keyBack.clear()
                classes = listaClasses[position]
                val keyA = ArrayList<String?>()


                if (aa.size >= 1){
                    if (listaClasses[0] == classes){
                        list.addAll(aa)
                        keyA.addAll(key)
                    }else{

                        for (i in 0..(aa.size -1)){
                            if (aa[i]?.classe == classes){
                                keyA.add(key[i])
                                list.add(aa[i])

                            }

                    }

                    }
                    keyBack.addAll(keyA)
                    alunoListBack.addAll(list)
                    adapter.setData(list, keyA)

                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }





        // Inflate the layout for this fragment
        return binding.root
    }


}