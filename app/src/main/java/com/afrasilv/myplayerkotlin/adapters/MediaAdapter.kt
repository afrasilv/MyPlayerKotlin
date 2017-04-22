package com.afrasilv.myplayerkotlin.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.afrasilv.myplayerkotlin.*
import kotlinx.android.synthetic.main.view_media_item.view.*
import kotlin.properties.Delegates

/**
 * Created by Alejandro Franco on 22/04/17.
 */

class MediaAdapter(val listener: (Item) -> Unit ) : RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    //Cuando cambie el tamaño de la lista, ejecutamos notifyDataSetChanged
    var data: List<Item> by Delegates.observable(emptyList()) {
        _, _, _ -> notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = parent.inflate(R.layout.view_media_item, false)
//        val v = LayoutInflater.from(parent.context).inflate(R.layout.view_media_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener{ listener(data[position])} // es igual a listener.invoke(data[position])
    }

    override fun getItemCount() = data.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val title = find<TextView>(R.id.media_title)
//        val thumb = find<ImageView>(R.id.media_thumb)
//        val mediaIndicator = find<ImageView>(R.id.media_video_indicator)

        fun bind(item: Item) = with(itemView) { // con la función with le pasamos un elemento y estamos 'dentro' después
            media_title.text = item.title
            media_thumb.loadUrl(item.url)
            media_video_indicator.visible = item.type == Item.Type.VIDEO

            //apply se devuelve a sí mismo, el TextView aquí, no la última línea.
            //Sirve para extender todos los objetos
            val textView = TextView(itemView.context).apply {
                text = "wew"
                visible = true
                textSize = 20f
            }
        } // la última línea del with se devuelve como return



//            title.text = item.title
//            thumb.loadUrl(item.url)
//            mediaIndicator.visible = item.type == Item.Type.VIDEO


//            itemView.media_title.text = item.title
//            itemView.media_thumb.loadUrl(item.url)
//            itemView.media_video_indicator.visible = item.type == Item.Type.VIDEO
//            itemView.setOnClickListener{ toast(item.title) }
    }
}