package com.example.ebd.UI.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ebd.R
import com.example.ebd.data.model.Aluno
import kotlinx.android.synthetic.main.recycler_lista.view.*

class AdapterListaAluno : RecyclerView.Adapter<AdapterListaAluno.ListaAlunoViewHolder>() {

    private var alunoList = ArrayList<Aluno>()
    private lateinit var context: Context

    class ListaAlunoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaAlunoViewHolder {
        context = parent.context
        return ListaAlunoViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_lista, parent,false))
    }

    override fun getItemCount(): Int {
        return alunoList.size
    }

    override fun onBindViewHolder(holder: ListaAlunoViewHolder, position: Int) {
        holder.itemView.recycler_tv_nome.text = alunoList[position].nome
        holder.itemView.recycler_tv_classe.text = alunoList[position].classe

    }

    fun setData(listAluno: ArrayList<Aluno>) {

        alunoList.addAll(listAluno)
        notifyDataSetChanged()
    }



}