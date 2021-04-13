package com.example.ebd.data.network

import com.google.firebase.auth.FirebaseAuth


class Repository {
        private val autentication = FirebaseAuth.getInstance()
        fun instanciFireAunth(): FirebaseAuth {
            return autentication
        }


}