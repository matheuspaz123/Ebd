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


class ChamadaFragment : Fragment() {

    lateinit var binding : FragmentChamadaBinding
    lateinit var mViewModel : ChamadaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(requireActivity()).get(ChamadaViewModel::class.java)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChamadaBinding.bind(inflater.inflate(R.layout.fragment_chamada, container, false))
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = ViewModelProvider(requireActivity()).get(ChamadaViewModel::class.java)
        chamada_cv_crianca.setOnClickListener {
            val navOptions = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_left)
                .setExitAnim(R.anim.slide_out_right)
                .build()
            mViewModel.classe.postValue(Constantes.CLASSESVETOR[0])

            findNavController().navigate(R.id.action_chamadaFragment_to_chamadaClasseFragment, null, navOptions)
        }

    }


}