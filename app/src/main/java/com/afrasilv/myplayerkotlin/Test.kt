package com.afrasilv.myplayerkotlin

import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Alejandro Franco on 22/04/17.
 */


fun test(view: View) {

    //Como estamos usando un when (switch)
    //en el lado derecho nos hace un autocasting con un if también nos funcionaría el autocasting
    when(view) {
        is TextView -> print(view.text)
        is ViewGroup -> print("children: ${view.childCount}")
    }

    //Cuando usamos el when como una expressión, necesitamos contemplar todos los resultados
    //ponemos que devuelve string, porque todos los resultados son string, si no sería Any
    val int = 10
    val result: String = when (int) {
        in 5..20 -> ""
        0,3,50 -> ""
        in 70..120 -> ""
        else -> throw IllegalStateException("No es un valor válido")
    }

    print(result)


    when {
        view is TextView -> print(view.text)
        System.currentTimeMillis() > 0 -> ""
    }

    //También podemos asignar el if a una variable para usarlo como una expresión
    val ifResult = if (view is TextView) 0 else 1

    val list = listOf(1,2,3)
    for (item in list){
        print("")
    }

    for (i in 1..10) { // 1 a 19 incluidos, 1 until 10 -> 10 no incluido

    }
}