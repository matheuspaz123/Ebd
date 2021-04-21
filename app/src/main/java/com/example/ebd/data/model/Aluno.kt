package com.example.ebd.data.model

class Aluno(var nome: String = "", var classe: String = "",var matriculado: Boolean = true, val presenca: Presenca = Presenca(""))
class Presenca(var dia: String = "")