package com.enesk.rickmorty.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.enesk.rickmorty.R
import com.enesk.rickmorty.data.remote.model.Character
import com.enesk.rickmorty.databinding.ItemCharactersBinding
import javax.inject.Inject

class HomeRecyclerAdapter():RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>(){

    class HomeViewHolder(val binding : ItemCharactersBinding): RecyclerView.ViewHolder(binding.root)

    private val diffUtil = object : DiffUtil.ItemCallback<Character>(){
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }
    }

    private val listDiffer = AsyncListDiffer(this,diffUtil)

    var diffList : List<Character>
        get() = listDiffer.currentList
        set(value) = listDiffer.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = ItemCharactersBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HomeViewHolder(view)

    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.binding.apply {
            tvCharacterName.text = diffList[position].name
            tvCharacterGender.text = diffList[position].gender
            tvCharacterStatus.text = diffList[position].status
            val imgCharacterProfile = diffList[position].image
            ivCharacterProfile.load(imgCharacterProfile){
                crossfade(true)
                crossfade(100)
            }

        }
    }

    override fun getItemCount(): Int {
        return diffList.size
    }

}