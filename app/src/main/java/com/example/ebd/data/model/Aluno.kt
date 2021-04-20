package com.example.ebd.data.model

class Aluno(var nome: String = "", var classe: String = "", val presenca: Presenca = Presenca("", ""))
class Presenca(var ano: String = "", var trimestre: String = "")