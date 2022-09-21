package com.example.players.data

import com.example.players.data.model.PlayerModel
import com.example.players.data.model.PlayerProvider
import com.example.players.data.network.PlayerService
import javax.inject.Inject

class PlayerRepository @Inject constructor(
    private val api : PlayerService,
    private val playerProvider: PlayerProvider
    ) {
    suspend fun getAllPlayers(): List<PlayerModel> {
        val response = api.getPlayers()
        playerProvider.players = response
        return response
    }
}