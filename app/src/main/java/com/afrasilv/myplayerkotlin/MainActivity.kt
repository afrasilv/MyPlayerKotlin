package com.afrasilv.myplayerkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.afrasilv.myplayerkotlin.adapters.MediaAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        val recycler = find<RecyclerView>(R.id.recycler)
        recycler.adapter = MediaAdapter(fetchMedia())

        this.toast("Hello world", Toast.LENGTH_SHORT)

//        //Con la función de extensión creada, podríamos hacer un start activity así:
//        startActivity<MainActivity>()
    }

}
