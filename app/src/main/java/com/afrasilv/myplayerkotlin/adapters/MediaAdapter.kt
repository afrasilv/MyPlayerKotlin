package com.afrasilv.myplayerkotlin.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.afrasilv.myplayerkotlin.*

/**
 * Created by Alejandro Franco on 22/04/17.
 */
class MediaAdapter(val data: List<Item>) : RecyclerView.Adapter<MediaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = parent.inflate(R.layout.view_media_item, false)
//        val v = LayoutInflater.from(parent.context).inflate(R.layout.view_media_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title = find<TextView>(R.id.media_title)
        val thumb = find<ImageView>(R.id.media_thumb)
        val mediaIndicator = find<ImageView>(R.id.media_video_indicator)

        fun bind(item: Item) {
            title.text = item.title
            thumb.loadUrl(item.url)
            mediaIndicator.visible = item.type == Item.Type.VIDEO
            itemView.setOnClickListener{ toast(item.title) }
        }
    }
}