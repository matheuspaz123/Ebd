package com.example.ebd.UI.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ebd.data.model.Aluno

class ChamadaViewModel : ViewModel() {
    val listaAluno = MutableLiveData<List<Aluno>>()


}