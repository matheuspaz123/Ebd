package com.example.ebd.UI.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ebd.R
import com.example.ebd.data.model.Aluno
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.recycler_lista.view.*

class AdapterListaAluno : RecyclerView.Adapter<AdapterListaAluno.ListaAlunoViewHolder>() {

    private var alunoList = ArrayList<Aluno?>()
    private var keyList = ArrayList<String?>()
    private lateinit var context: Context

    class ListaAlunoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaAlunoViewHolder {
        context = parent.context
        return ListaAlunoViewHolder(
            LayoutInflater.from(context).inflate(R.layout.recycler_lista, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return alunoList.size
    }

    private fun bind(holder: ListaAlunoViewHolder, position: Int, list: ArrayList<Aluno?>) {

        holder.itemView.recycler_tv_nome.text = list[position]?.nome
        holder.itemView.recycler_tv_classe.text = list[position]?.classe
        holder.itemView.setOnLongClickListener {
            val dialog = AlertDialog.Builder(context)
            dialog.setTitle("Deseja deletar este aluno?")
            dialog.setPositiveButton("sim", DialogInterface.OnClickListener { dialog, which ->

                keyList[position]
                val referenciaDelete =
                    FirebaseDatabase.getInstance().reference.child("alunos")
                referenciaDelete.child(keyList[position]!!).removeValue()
                Toast.makeText(context, "Aluno deletado", Toast.LENGTH_SHORT).show()
            })
            dialog.setNegativeButton("não", DialogInterface.OnClickListener { dialog, which -> })
            dialog.show()




            false
        }

    }

    override fun onBindViewHolder(holder: ListaAlunoViewHolder, position: Int) {


        bind(holder, position, alunoList)

    }

    fun setData(listAluno: ArrayList<Aluno?>, keyNo: ArrayList<String?>) {
        keyList.clear()
        alunoList.clear()
        keyList.addAll(keyNo)
        alunoList.addAll(listAluno)
        notifyDataSetChanged()
    }


}