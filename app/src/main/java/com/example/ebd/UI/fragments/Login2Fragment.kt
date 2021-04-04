package com.example.ebd.UI.fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.ebd.R
import com.example.ebd.databinding.FragmentHomeBinding
import com.example.ebd.databinding.FragmentLogin2Binding

private lateinit var binding: FragmentHomeBinding

class Login2Fragment : Fragment() {




    lateinit var binding : FragmentLogin2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login2, container, false)
        binding = FragmentLogin2Binding.bind(view)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val userr = User("matheus", "12345678")

        binding.loginBt.setOnClickListener {

            //animação de transição
            val navOptions = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_left)
                .setExitAnim(R.anim.slide_out_right)
                .build()
             findNavController().navigate(R.id.action_login2Fragment_to_homeFragment, null, navOptions)
        }

    }




}