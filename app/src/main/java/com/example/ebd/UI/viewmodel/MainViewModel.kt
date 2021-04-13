package com.example.ebd.UI.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ebd.data.network.Repository
import com.google.firebase.auth.FirebaseAuth
import org.koin.java.KoinJavaComponent.inject


class MainViewModel : ViewModel() {
    private val autentication:Repository by inject(Repository::class.java)


    fun getAutentication():FirebaseAuth = autentication.instanciFireAunth()

}