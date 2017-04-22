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
            Item(1, "Title 1", "http://lorempixel.com/400/400/cats/1/", Item.Type.PHOTO),
            Item(2, "Title 2", "http://lorempixel.com/400/400/cats/2/", Item.Type.PHOTO),
            Item(3, "Title 3", "http://lorempixel.com/400/400/cats/3/", Item.Type.VIDEO),
            Item(4, "Title 4", "http://lorempixel.com/400/400/cats/4/", Item.Type.VIDEO),
            Item(5, "Title 5", "http://lorempixel.com/400/400/cats/5/", Item.Type.PHOTO)
    )

    fun fetchMedia(): List<Item> = (1..10).map {
        Item(it, "Title $it", "http://lorempixel.com/400/400/cats/$it/",
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

        // Check nulls
        val item: Item? = null
        item?.title

        val nonNullItem : Item = item ?: Item(1, "It1", "url", Item.Type.PHOTO)
        val title: String = item?.title ?: ""

        val title2: String = item!!.title //saltarse comprobación de si es null

        item?.title?.let { // si ambos son distintos de null
            print(it) // it = title
        }

//    (0..10)
//    (10 downTo 0)
//    (0 until 10 step 2)

    }
}