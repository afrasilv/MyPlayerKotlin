package com.afrasilv.myplayerkotlin

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by Alejandro Franco on 22/04/17.
 */

//object myObject //funciona como un objeto normal pero solo tiene 1 instancia -> Singleton
object MediaProvider {

    //al ser lazy, no se inicializa si no se llega a usar

    fun dataAsync(f:(List<Item>) -> Unit) {
        doAsync {
            val data = fetchMedia()
            Thread.sleep(2000)

            uiThread { f(data) }
        }
    }

    fun fetchMedia2(): List<Item> = listOf(
            Item("Title 1", "http://lorempixel.com/400/400/cats/1/", Item.Type.PHOTO),
            Item("Title 2", "http://lorempixel.com/400/400/cats/2/", Item.Type.PHOTO),
            Item("Title 3", "http://lorempixel.com/400/400/cats/3/", Item.Type.VIDEO),
            Item("Title 4", "http://lorempixel.com/400/400/cats/4/", Item.Type.VIDEO),
            Item("Title 5", "http://lorempixel.com/400/400/cats/5/", Item.Type.PHOTO)
    )

    fun fetchMedia(): List<Item> = (1..10).map {
        Item("Title $it", "http://lorempixel.com/400/400/cats/$it/",
                if (it % 3 == 0) Item.Type.VIDEO else Item.Type.PHOTO
        )
    }


    fun test() {
        //obtenemos una lista inmutable de enteros
        val list = listOf<Int>(1, 4, 3, 2)

        val newList = list
                .filter { it % 2 == 0 }
                .sortedBy(Int::toString)
                .map { "Title $it" }

//    (0..10)
//    (10 downTo 0)
//    (0 until 10 step 2)

    }
}