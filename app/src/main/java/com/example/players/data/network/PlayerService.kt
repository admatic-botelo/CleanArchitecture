package com.example.players.data.network

import com.example.players.core.RetrofitHelper
import com.example.players.data.model.PlayerModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PlayerService @Inject constructor(private val api : PlayerApiClient) {

    suspend fun getPlayers(): List<PlayerModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllPlayers()
            response.body() ?: emptyList()
        }
    }
}