package com.enesk.rickmorty.ui.home.listener

import com.enesk.rickmorty.data.remote.model.character.Character

interface ItemClickListener {

    fun onItemClick(character : Character)

}