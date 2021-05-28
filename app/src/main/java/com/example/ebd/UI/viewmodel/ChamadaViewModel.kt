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



    init {
        iniciar()
    }

    private fun iniciar() {
        val totalClassesDb = dataBase.child("alunos")
        totalClassesDb.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val key = ArrayList<String?>()
                val totalClasses = ArrayList<Aluno?>()

                for (document in snapshot.children) {
                    key.add(document.key)
                    totalClasses.add(document.getValue(Aluno::class.java))
                }
                listaAluno.postValue(totalClasses)
                keys.postValue(key)
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

    }


}