package com.example.ebd.UI.viewmodel

import androidx.lifecycle.LiveData
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
    private val autentication: Repository by inject(Repository::class.java)
    private val dataBase = FirebaseDatabase.getInstance().reference
    private val mTotalClasses = MutableLiveData<List<Aluno?>>()
    private val key = ArrayList<String?>()
    private val mkey = ArrayList<String?>()
    private val totalClasses = ArrayList<Aluno?>()
    private val mClasses = ArrayList<Aluno?>()


    init {
        iniciarRealTime()
    }

    fun iniciarRealTime() {
        val totalClassesDb = dataBase.child("alunos")
        totalClassesDb.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                totalClasses.clear()
                key.clear()
                for (document in snapshot.children) {
                    key.add(document.key)
                    totalClasses.add(document.getValue(Aluno::class.java))
                }
                mTotalClasses.postValue(totalClasses)
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

    fun getAlunosClasse(classe: String) {
        mClasses.clear()
        mkey.clear()
        for (i in 0..(totalClasses.size - 1)) {
            if (totalClasses[i]?.classe == classe) {
                mClasses.add(totalClasses[i])
                mkey.add(key[i])
            }
        }
    }


    fun getAutentication(): FirebaseAuth = autentication.instanciFireAunth()

}