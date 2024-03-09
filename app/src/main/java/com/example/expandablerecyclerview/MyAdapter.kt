package com.example.expandablerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val itemList: List<ItemData>) : RecyclerView.Adapter<MyAdapter.myViewHolder>(){

    class myViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val imgIcon = itemView.findViewById<ImageView>(R.id.icon_image)
        val imgExpand = itemView.findViewById<ImageView>(R.id.img_expand)
        val tv_title = itemView.findViewById<TextView>(R.id.tv_title)
        val tv_description = itemView.findViewById<TextView>(R.id.tv_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.items_list,parent,false)
        return myViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        val currentItem = itemList[position]

        holder.tv_title.text = currentItem.title
        holder.tv_description.text = currentItem.description
        holder.imgIcon.setImageResource(currentItem.imageIcon)

        holder.imgExpand.setOnClickListener(){

            if(holder.tv_description.visibility == View.GONE){
                holder.tv_description.visibility = View.VISIBLE

                holder.imgExpand.setImageResource(R.drawable.up_arrow)
            }
            else{
                holder.tv_description.visibility = View.GONE

                holder.imgExpand.setImageResource(R.drawable.down_arrow)
            }
        }

    }


}