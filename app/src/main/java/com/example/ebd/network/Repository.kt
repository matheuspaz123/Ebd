package com.example.ebd.network

import com.google.firebase.auth.FirebaseAuth


class Repository {
    companion object{
        private val autentication = FirebaseAuth.getInstance()
        fun instanciFireAunth(): FirebaseAuth {
            return autentication
        }
    }

}