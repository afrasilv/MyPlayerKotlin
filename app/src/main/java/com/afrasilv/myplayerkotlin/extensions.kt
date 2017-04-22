package com.afrasilv.myplayerkotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

/**
 * Created by Alejandro Franco on 22/04/17.
 */


fun Context.toast(textToast: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, textToast, length).show()
}

fun RecyclerView.ViewHolder.toast(textToast: String, length: Int = Toast.LENGTH_SHORT) {
    itemView.context.toast(textToast, length)
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun ImageView.loadUrl(url: String) = Picasso.with(context).load(url).into(this)

inline fun <reified T: Activity> Context.startActivity() {
    startActivity(Intent(this, T::class.java))
}

inline fun <reified T: View> View.find(@IdRes idRes: Int): T {
    return findViewById(idRes) as T
}

inline fun <reified T: View> Activity.find(@IdRes idRes: Int) = findViewById(idRes) as T


inline fun <reified T: View> RecyclerView.ViewHolder.find(@IdRes idRes: Int): T {
    return itemView.find<T>(idRes)
}

var View.visible : Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }


/**
 * Lambdas
 */
fun <T: Any> T.apply2(f: T.() -> Unit): T {
    this.f()
    return this
}

fun <T: Any> with2(obj: T, f: T.() -> Unit): T{
    obj.f()
    return obj
}

fun ViewGroup.filterViews( condition: (View) -> Boolean ): List<View> {
    val list = mutableListOf<View>()
    for (i in 0 until childCount) {
        val view = getChildAt(i)
        if ( condition(view) ) {
            list.add(view)
        }
    }
    return list
}

