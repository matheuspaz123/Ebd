package com.example.ebd.UI.fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ebd.R
import com.example.ebd.databinding.FragmentLogin2Binding


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
        return inflater.inflate(R.layout.fragment_login2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val userr = User("matheus", "12345678")
        binding = FragmentLogin2Binding.bind(view)
        //binding.user = userr
        binding.loginBt.setOnClickListener {
             findNavController().navigate(R.id.action_login2Fragment_to_homeFragment)
        }

    }




}