package com.example.ebd.UI.fragments

import android.app.Service
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.ebd.R
import com.example.ebd.databinding.FragmentHomeBinding
import com.example.ebd.databinding.FragmentLogin2Binding
import com.example.ebd.viewmodel.MainViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login2.view.*


class Login2Fragment : Fragment() {

    var connectivity: ConnectivityManager? = null
    var info: NetworkInfo? = null
    private lateinit var mMainViewModel: MainViewModel
    private lateinit var binding: FragmentLogin2Binding
    private lateinit var autentication: FirebaseAuth


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
        mMainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.loginBt.setOnClickListener {
            conection()
            val email = (binding.loginEtUsuario.text.toString().trim() + "@teste.com")
            val senha = view.login_et_senha.text.toString()
            login(email, senha)
        }

        return binding.root
    }

    private fun login(email: String, senha: String) {
        if (conection()) {

            if (validation(email, senha)) {

                mMainViewModel.getAutentication().signInWithEmailAndPassword(email, senha)
                    .addOnCompleteListener {
                        if (it.isSuccessful) transitionHome() else Toast.makeText(
                            context,
                            "Usuario ou senha incorreto",
                            Toast.LENGTH_SHORT
                        ).show()
                    }


            } else {
                Toast.makeText(
                    context,
                    "Usuario ou senha vazio",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }

    private fun transitionHome() {
        //animação de transição
        val navOptions = NavOptions.Builder()
            .setEnterAnim(R.anim.slide_in_left)
            .setExitAnim(R.anim.slide_out_right)
            .build()
        findNavController().navigate(
            R.id.action_login2Fragment_to_homeFragment,
            null,
            navOptions
        )
    }

    private fun validation(email: String, senha: String) = email.isNotEmpty() && senha.isNotEmpty()

    //testando a conexão de internet
    private fun conection(): Boolean {

        var context = this.context
        connectivity = context!!.getSystemService(Service.CONNECTIVITY_SERVICE)
                as ConnectivityManager

        if (connectivity != null) {

            info = connectivity!!.activeNetworkInfo

            if (info != null) {
                if (info!!.state == NetworkInfo.State.CONNECTED) {
                    return true
                }
            } else {
                Toast.makeText(context, "sem internet", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        return false

    }


}