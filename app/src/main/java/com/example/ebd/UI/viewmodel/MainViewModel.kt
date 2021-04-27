package com.example.ebd.UI.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ebd.data.model.Aluno
import com.example.ebd.data.network.Repository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import org.koin.java.KoinJavaComponent.inject


class MainViewModel : ViewModel() {
    private val autentication:Repository by inject(Repository::class.java)
    private val dataBase = FirebaseDatabase.getInstance().reference
    private val mTotalClasses = MutableLiveData<List<Aluno?>>()
    private val key = ArrayList<String?>()

    init {
        iniciarRealTime()
    }

    fun iniciarRealTime(){
        val totalClassesDb = dataBase.child("alunos")
        totalClassesDb.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val totalClasses = ArrayList<Aluno?>()
                key.clear()
                for (document in snapshot.children){
                    key.add(document.key)
                    totalClasses.add(document.getValue(Aluno::class.java))
                }
                mTotalClasses.postValue(totalClasses)
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }



    fun getAutentication():FirebaseAuth = autentication.instanciFireAunth()

}