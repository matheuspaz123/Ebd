package com.example.ebd.UI.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ebd.data.model.Aluno
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ChamadaViewModel : ViewModel() {
    val listaAluno = MutableLiveData<ArrayList<Aluno?>>()
    val keys = MutableLiveData<List<String?>>()
    private val dataBase = FirebaseDatabase.getInstance().reference
    val classe = MutableLiveData<String>()




    fun iniciarListAlunos(): ArrayList<Aluno?> {
        val totalClassesDb = dataBase.child("alunos")
        var a = ArrayList<Aluno?>()
        totalClassesDb.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val key = ArrayList<String?>()
                val totalClasses = ArrayList<Aluno?>()

                for (document in snapshot.children) {
                    key.add(document.key)
                    totalClasses.add(document.getValue(Aluno::class.java))
                }
                a.addAll(totalClasses)
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

        return a
    }
    fun iniciarKeys(): ArrayList<String?> {
        val totalClassesDb = dataBase.child("alunos")
        var a = ArrayList<String?>()
        totalClassesDb.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val key = ArrayList<String?>()
                val totalClasses = ArrayList<Aluno?>()

                for (document in snapshot.children) {
                    key.add(document.key)
                    totalClasses.add(document.getValue(Aluno::class.java))
                }
                a.addAll(key)
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

        return a
    }

    fun getListSelectedClasse(): ArrayList<Aluno?> {
        val a = classe.value
        val aa = listaAluno.value
        val t = utilFiltarClasses(a, aa as List<Aluno?>)
        val f = a

        return t
    }

    private fun utilFiltarClasses (classe : String?, listaAluno: List<Aluno?>) : ArrayList<Aluno?>{

        val auxList = ArrayList<Aluno?>()
        for (i in 0..listaAluno.size){
            if (listaAluno[i]?.classe  == classe){
                auxList.add(listaAluno[i])
            }
        }
        return auxList
    }


}