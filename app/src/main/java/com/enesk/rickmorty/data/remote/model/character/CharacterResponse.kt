package com.enesk.rickmorty.data.remote.model.character

import com.enesk.rickmorty.data.remote.model.character.Character
import com.google.gson.annotations.SerializedName


data class CharacterResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Character>
)