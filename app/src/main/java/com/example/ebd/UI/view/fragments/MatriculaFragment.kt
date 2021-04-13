package com.example.ebd.UI.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ebd.R
import com.example.ebd.data.model.Aluno
import com.example.ebd.databinding.FragmentLogin2Binding
import com.example.ebd.databinding.FragmentMatriculaBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class MatriculaFragment : Fragment() {

    private lateinit var binding: FragmentMatriculaBinding
    private val db = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatriculaBinding.bind(
            inflater.inflate(
                R.layout.fragment_matricula,
                container,
                false
            )
        )
        var aluno = Aluno("teste", "testeclasse")

        binding.matriculaBtSalvar.setOnClickListener {
            aluno = Aluno(
                binding.matriculaEtNome.text.toString(),
                binding.matriculaEtClasse.text.toString()
            )

            db.collection("usuarios")
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
        }



        // Inflate the layout for this fragment
        return binding.root
    }

}