package com.example.ebd.data.model

import androidx.navigation.NavOptions
import com.example.ebd.R

class Constantes {
    companion object {
        //Animação de transição
        val TRANSITIONFRAG = NavOptions.Builder()
            .setEnterAnim(R.anim.slide_in_left)
            .setExitAnim(R.anim.slide_out_right)
            .build()

        val CLASSESVETOR = arrayOf(
            "Jovens",
            "Crianças",
            "Adolecentes",
            "Varões",
            "Irmãs",
            "Novos convertidos"
        )

        val CLASSESTOTALVETOR = arrayOf(
        "Todos",
        "Jovens",
        "Crianças",
        "Adolecentes",
        "Varões",
        "Irmãs",
        "Novos convertidos"
        )

    }
}