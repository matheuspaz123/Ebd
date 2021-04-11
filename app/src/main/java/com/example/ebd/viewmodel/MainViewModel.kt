package com.example.ebd.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ebd.network.Repository


class MainViewModel : ViewModel() {
    private val autentication = Repository.instanciFireAunth()

    fun getAutentication() = autentication

}