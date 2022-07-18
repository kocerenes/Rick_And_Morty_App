package com.enesk.rickmorty.ui.home.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.enesk.rickmorty.data.remote.model.character.Character
import com.enesk.rickmorty.databinding.ItemCharactersBinding
import com.enesk.rickmorty.ui.home.HomeFragmentDirections
import com.enesk.rickmorty.ui.home.listener.ItemClickListener
import com.enesk.rickmorty.utils.CharacterStatusEnums

class HomeRecyclerAdapter(
    private val onClickListener: ItemClickListener
) :
    PagingDataAdapter<Character, HomeRecyclerAdapter.HomeViewHolder>(diffUtil) {

    inner class HomeViewHolder(val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = ItemCharactersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        val character = getItem(position)

        if (character != null) {
            holder.binding.apply {
                tvCharacterName.text = character.name
                tvCharacterGender.text = character.gender
                tvCharacterStatus.text = character.status
                val imgCharacterProfile = character.image
                ivCharacterProfile.load(imgCharacterProfile) {
                    crossfade(true)
                    crossfade(100)
                }


                when (character.status) {
                    CharacterStatusEnums.CHARACTER_ALIVE.value -> imgCharacterStatus.setColorFilter(
                        Color.parseColor("#14D91B")
                    )
                    CharacterStatusEnums.CHARACTER_DEAD.value -> imgCharacterStatus.setColorFilter(
                        Color.parseColor("#FF0800")
                    )
                    CharacterStatusEnums.CHARACTER_UNKNOWN.value -> imgCharacterStatus.setColorFilter(
                        Color.parseColor("#E3E3E3")
                    )
                    else -> imgCharacterStatus.setColorFilter(Color.parseColor("#F8F816"))
                }
            }


            holder.itemView.setOnClickListener {
                onClickListener.onItemClick(character)
            }

        }
    }



}