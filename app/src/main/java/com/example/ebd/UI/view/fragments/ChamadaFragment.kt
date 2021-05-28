package com.example.ebd.UI.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.ebd.R
import com.example.ebd.UI.viewmodel.ChamadaViewModel
import com.example.ebd.data.model.Constantes
import com.example.ebd.databinding.FragmentChamadaBinding
import kotlinx.android.synthetic.main.fragment_chamada.*


class ChamadaFragment : Fragment(), View.OnClickListener {

    lateinit var binding: FragmentChamadaBinding
    lateinit var mViewModel: ChamadaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(requireActivity()).get(ChamadaViewModel::class.java)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChamadaBinding.bind(
            inflater.inflate(
                R.layout.fragment_chamada,
                container,
                false
            )
        )
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = ViewModelProvider(requireActivity()).get(ChamadaViewModel::class.java)

        setListeners()

    }

    fun setListeners(){
        chamada_cv_crianca.setOnClickListener(this)
        chamada_cv_adolecente.setOnClickListener(this)
        chamada_cv_irma.setOnClickListener(this)
        chamada_cv_jovens.setOnClickListener(this)
        chamada_cv_novos.setOnClickListener(this)
        chamada_cv_varoes.setOnClickListener(this)
    }

    fun transition() {
        findNavController().navigate(
            R.id.action_chamadaFragment_to_chamadaClasseFragment,
            null,
            Constantes.TRANSITIONFRAG
        )
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            //Passa o nome da classe que irá ser feita a chamada para a variavel na viewmodel global
            R.id.chamada_cv_jovens -> mViewModel.classe.postValue(Constantes.CLASSESVETOR[0])
            R.id.chamada_cv_crianca -> mViewModel.classe.postValue(Constantes.CLASSESVETOR[1])
            R.id.chamada_cv_adolecente -> mViewModel.classe.postValue(Constantes.CLASSESVETOR[2])
            R.id.chamada_cv_varoes -> mViewModel.classe.postValue(Constantes.CLASSESVETOR[3])
            R.id.chamada_cv_irma -> mViewModel.classe.postValue(Constantes.CLASSESVETOR[4])
            R.id.chamada_cv_novos -> mViewModel.classe.postValue(Constantes.CLASSESVETOR[5])
        }

        transition()
    }


}