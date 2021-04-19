package com.example.ebd.UI.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.ArrayAdapter
import com.example.ebd.R
import com.example.ebd.data.model.Aluno
import com.example.ebd.databinding.FragmentLogin2Binding
import com.example.ebd.databinding.FragmentMatriculaBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_matricula.view.*


class MatriculaFragment : Fragment() {

    private lateinit var binding: FragmentMatriculaBinding
    private val db = Firebase.firestore
    private val dataBase = FirebaseDatabase.getInstance().reference
    private var listaClasses = arrayOf(
        "Jovens",
        "Crianças",
        "Adolecentes",
        "Varões",
        "Irmãs",
        "Novos convertidos"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(
            R.layout.fragment_matricula,
            container,
            false
        )

        binding = FragmentMatriculaBinding.bind(view)

        var mArrayAdapter =
            ArrayAdapter(view.context, android.R.layout.simple_spinner_item, listaClasses)
        //mArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        view.matricula_sp_classe.adapter = mArrayAdapter

        var aluno = Aluno("teste", "testeclasse")

        binding.matriculaBtSalvar.setOnClickListener {
            aluno = Aluno(
                binding.matriculaEtNome.text.toString(),
                "Jovens"
                //binding.matriculaSpClasse.text.toString()
            )

            val reference = dataBase.child("alunos")
                .child(aluno.nome)
            reference.setValue(aluno)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(
                            context,
                            "Salvo",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            context,
                            "falha",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }


            /*      db.collection("usuarios")
                      .add(aluno)
                      .addOnSuccessListener {
                          Toast.makeText(
                              context,
                              "Salvo",
                              Toast.LENGTH_SHORT
                          ).show()
                      }.addOnFailureListener {
                          Toast.makeText(
                              context,
                              "falha",
                              Toast.LENGTH_SHORT
                          ).show()
                      }

             */

        }


        // Inflate the layout for this fragment
        return binding.root
    }

}