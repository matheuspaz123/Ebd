package com.example.ebd.utils

import com.example.ebd.data.model.Aluno

fun utilFiltarClasses (classe : String?, listaAluno: ArrayList<Aluno?>) : List<Aluno?>{

    val auxList = ArrayList<Aluno?>()
    for (i in 0 until listaAluno.size){
        if (listaAluno[i]?.classe  == classe){
            auxList.add(listaAluno[i])
        }
    }
    return auxList
}