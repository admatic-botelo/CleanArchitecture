package com.example.players.data.model

import com.google.gson.annotations.SerializedName

data class PlayerModel(
    @SerializedName("player_name") val name: String,
    @SerializedName("player_type") val type: String,
    @SerializedName("player_number") val number: String,
    @SerializedName("player_age") val age: String,
    @SerializedName("player_match_played") val matches: String,
    @SerializedName("player_goals") val goals: String,
    @SerializedName("player_image") val image: String
)