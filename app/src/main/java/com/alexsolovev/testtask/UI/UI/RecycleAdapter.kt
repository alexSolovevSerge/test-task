package com.alexsolovev.testtask.UI.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.alexsolovev.testtask.R
import com.alexsolovev.testtask.UI.model.ImageModel
import kotlinx.android.synthetic.main.card_layout.view.*

class RecycleAdapter(
    private val exampleList: List<ImageModel>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<RecycleAdapter.ImagesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ImagesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        val currentItem = exampleList.get(position)
        holder.imageView.load(currentItem?.download_url)
    }

    override fun getItemCount(): Int {
        return exampleList.size
    }

    inner class ImagesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val imageView: ImageView = itemView.card_image_view

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }

    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}