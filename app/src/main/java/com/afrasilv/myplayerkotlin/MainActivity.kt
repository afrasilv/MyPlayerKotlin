package com.afrasilv.myplayerkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.afrasilv.myplayerkotlin.adapters.MediaAdapter
import kotlinx.android.synthetic.main.activity_recycler.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {


//    var observedNumber by Delegates.observable(0) {
//        p, old, new -> Log.d("", "old value: $old, new value: $new");
//    }

    val adapter = MediaAdapter{

        startActivity<DetailActivity>(DetailActivity.EXTRA_ITEM_ID to it.id)

    }

//    //sustitute a las funciones y variables estáticas de java
//    companion object { //puede extender de lo que queramos
//        val x = 20
//    }
//    //con MainActivity.x podríamos llamarlo de donde quisiéramos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        //si activamos el plugin de kotlin 'kotlin-android-extensions' no hace falta que hagamos los findView porque accede a todo lo que hay dentro
        //va a compilar incluso aunque no exista ese id
//        val recycler = find<RecyclerView>(R.id.recycler)

        recycler.adapter = adapter
        progress.visible = true
        MediaProvider.dataAsync { // items ->
            adapter.data = it // = items
            progress.visible = false
        }

        //desde la version 1.1.1 de Kotlin se puede hacer también Delegates en variables
        val lazyVar by lazy {}

        /*  val tv = TextView(this).apply2 {
              textSize = 20f
          }

          val tv2 = with2(TextView(this)) {
              textSize = 20f
          }

          val viewGroup: ViewGroup = FrameLayout(this)
          val list: List<View> = viewGroup.filterViews { view -> view.visible }

          this.toast("Hello world", Toast.LENGTH_SHORT)*/

//        //Con la función de extensión creada, podríamos hacer un start activity así:
//        startActivity<MainActivity>()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        progress.visible = true

        val filter = when(item.itemId) {
            R.id.filter_photos -> Filter.ByType(Item.Type.PHOTO)
            R.id.filter_videos -> Filter.ByType(Item.Type.VIDEO)
            else -> Filter.None
        }

        MediaProvider.dataAsync { items ->
            adapter.data = when(filter) {
                is Filter.ByType -> items.filter { it.type == filter.type}
                is Filter.None -> items
            }
        }

//        MediaProvider.dataAsync {  items ->
//            adapter.data = when(item.itemId) {
//                R.id.filter_photos -> items.filter { it.type == Item.Type.PHOTO }
//                R.id.filter_videos -> items.filter { it.type == Item.Type.VIDEO }
//                else -> items
//            }
//            progress.visible = false
//        }

        return true
    }

}