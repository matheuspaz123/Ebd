package com.example.ebd.di.modules

import com.example.ebd.UI.viewmodel.MainViewModel
import com.example.ebd.data.network.Repository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val mainViewModelModule = module {

    single {
        return@single Repository()
    }
    viewModel {
        MainViewModel()
    }
}