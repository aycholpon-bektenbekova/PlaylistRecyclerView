package com.example.playlistrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.playlistrecyclerview.databinding.ItemSoundsBinding

class PlaylistAdapter(
    val soundList: List<Sound>,
    val onClick:(position: Int) -> Unit
): RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(ItemSoundsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = soundList.size

    inner class PlaylistViewHolder(private val binding: ItemSoundsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(){
            val item = soundList[adapterPosition]

            itemView.setOnClickListener{
                onClick(adapterPosition)
            }

            binding.sound.text = item.name
            binding.singer.text = item.singer
        }
    }
}

