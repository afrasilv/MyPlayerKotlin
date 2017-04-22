package com.afrasilv.myplayerkotlin

import android.app.VoiceInteractor

/**
 * Created by Alejandro Franco on 22/04/17.
 */

sealed class Option {
    object None: Option()
    class Some(val value: Int) : Option()
}

//como el compilador sabe que solo tenemos 2 options, no nos pide el else
fun test2 (option: Option) {
    when(option) {
        is Option.Some -> print("value: ${option.value}")
        is Option.None -> print("Empty option")
    }
}

/////////////////

sealed class Filter {
    object None: Filter()
    class ByType(val type: Item.Type) : Filter()
}