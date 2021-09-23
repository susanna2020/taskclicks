package com.susana.task.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.susana.task.R
import com.susana.task.data.NewsModel
import com.susana.task.ui.MainActivity

class NewsAdapter(private val context: Context, private val newsList: List<NewsModel>, private val onItemClickListener: OnItemClickListener)
:RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){



    class NewsViewHolder(itemView : View, onItemClickListener: OnItemClickListener):RecyclerView.ViewHolder(itemView){

        val cardImage: ImageView =itemView.findViewById(R.id.item_image)

        init {

            itemView.setOnClickListener {
                onItemClickListener.onClick(adapterPosition)
            }

        }
    }


    override fun getItemCount()=newsList.size

    interface  OnItemClickListener{
        fun onClick(position: Int)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item,
            parent, false)
        return NewsViewHolder(itemView,onItemClickListener)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = newsList[position]

        val url=currentItem.articles.get(position).urlToImage
        Glide
            .with(context)
            .load(url)
            .centerCrop()
            .into(holder.cardImage);

    }
}