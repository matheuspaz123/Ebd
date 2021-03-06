package com.example.ebd.UI.view.fragments

import android.app.Service
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.ebd.R
import com.example.ebd.databinding.FragmentLogin2Binding
import com.example.ebd.UI.viewmodel.MainViewModel
import com.example.ebd.data.network.Repository
import kotlinx.android.synthetic.main.fragment_login2.view.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel



class Login2Fragment : Fragment() {

    var connectivity: ConnectivityManager? = null
    var info: NetworkInfo? = null
    private val mMainViewModel: MainViewModel by viewModel()
    private lateinit var binding: FragmentLogin2Binding

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

        binding.loginBt.setOnClickListener {
            conection()
            val email = (binding.loginEtUsuario.text.toString().trim() + "@teste.com")
            val senha = view.login_et_senha.text.toString()

            //entrar rapido
            if (binding.loginEtUsuario.text.toString() == "2000"){
                transitionHome()
            }


            login(email, senha)
        }

        return binding.root
    }

    //validando paremetros de entrada de login
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
                    "Usuario e senha vazios",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }

    //navegar para homeFragmento
    private fun transitionHome() {
        //anima????o de transi????o
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

    //Checando se login e senha n??o s??o vazios
    private fun validation(email: String, senha: String) = email.isNotEmpty() && senha.isNotEmpty()

    //testando a conex??o de internet
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