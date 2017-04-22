package com.afrasilv.myplayerkotlin

/**
 * Created by Alejandro Franco on 22/04/17.
 */
data class Item (val title: String, val url: String, val type: Type) {
    enum class Type { PHOTO, VIDEO }
}
