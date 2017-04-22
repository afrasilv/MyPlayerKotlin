package com.afrasilv.myplayerkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.afrasilv.myplayerkotlin.adapters.MediaAdapter
import kotlinx.android.synthetic.main.activity_recycler.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        //si activamos el plugin de kotlin 'kotlin-android-extensions' no hace falta que hagamos los findView porque accede a todo lo que hay dentro
        //va a compilar incluso aunque no exista ese id
//        val recycler = find<RecyclerView>(R.id.recycler)

        recycler.adapter = MediaAdapter(fetchMedia())

        this.toast("Hello world", Toast.LENGTH_SHORT)

//        //Con la función de extensión creada, podríamos hacer un start activity así:
//        startActivity<MainActivity>()
    }

}
