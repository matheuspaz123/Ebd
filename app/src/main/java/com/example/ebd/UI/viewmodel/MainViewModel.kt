package com.example.ebd.UI.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ebd.data.network.Repository


class MainViewModel : ViewModel() {
    private val autentication = Repository.instanciFireAunth()

    fun getAutentication() = autentication

}