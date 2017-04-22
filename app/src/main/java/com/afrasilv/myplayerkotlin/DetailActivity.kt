package com.afrasilv.myplayerkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_ITEM_ID = "DetailActivity:itemId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getIntExtra(EXTRA_ITEM_ID, -1)

        val item = MediaProvider.fetchMedia().firstOrNull {
            it.id == id
        }

        item?.apply {
            supportActionBar?.title = title
            detail_thumb.loadUrl(url)
            detail_video_indicator.visible = type == Item.Type.VIDEO
        }
    }
}
