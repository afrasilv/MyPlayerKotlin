package com.afrasilv.myplayerkotlin

/**
 * Created by Alejandro Franco on 22/04/17.
 */

fun fetchMedia(): List<Item> = listOf(
        Item("Title 1", "http://lorempixel.com/400/400/cats/1/", Item.Type.PHOTO),
        Item("Title 2", "http://lorempixel.com/400/400/cats/2/", Item.Type.PHOTO),
        Item("Title 3", "http://lorempixel.com/400/400/cats/3/", Item.Type.VIDEO),
        Item("Title 4", "http://lorempixel.com/400/400/cats/4/", Item.Type.VIDEO),
        Item("Title 5", "http://lorempixel.com/400/400/cats/5/", Item.Type.PHOTO)
)