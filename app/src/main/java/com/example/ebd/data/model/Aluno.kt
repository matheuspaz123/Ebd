package com.example.ebd.data.model

class Aluno(var nome: String = "", var classe: String = "",var matriculado: Boolean = true, val presenca: Presenca = Presenca(""))
class Presenca2(dia: String = "", matriculado: Boolean = true)
class Presenca(var dia: String = "")