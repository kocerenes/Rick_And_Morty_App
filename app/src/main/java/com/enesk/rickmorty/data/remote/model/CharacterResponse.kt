package com.enesk.rickmorty.data.remote.model

import com.google.gson.annotations.SerializedName


data class CharacterResponse(
    @SerializedName("results")
    val results: List<Character>?
)