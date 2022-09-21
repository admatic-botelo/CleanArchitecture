package com.example.players.domain

import com.example.players.data.model.PlayerModel
import com.example.players.data.model.PlayerProvider
import javax.inject.Inject

class GetRandomPlayerUseCase @Inject constructor(private val playerProvider: PlayerProvider) {

    operator fun invoke():PlayerModel?{
        val players = playerProvider.players
        if(!players.isNullOrEmpty()){
            val randomNumber = (players.indices).random()
            return players[randomNumber]
        }
        return null
    }
}