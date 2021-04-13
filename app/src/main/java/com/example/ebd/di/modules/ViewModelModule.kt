package com.example.ebd.di.modules

import com.example.ebd.UI.viewmodel.MainViewModel
import com.example.ebd.data.network.Repository
import com.google.firebase.auth.FirebaseAuth
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module


val mainViewModelModule = module {

    single{
        Repository()
    }
    viewModel {
        MainViewModel()
    }
}
