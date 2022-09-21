package com.example.players.data.network

import com.example.players.data.model.PlayerModel
import retrofit2.Response
import retrofit2.http.GET

interface PlayerApiClient {
    @GET("3e9d5124-61e5-4b9c-9dc6-78113d6935ca")
    suspend fun getAllPlayers(): Response<List<PlayerModel>>
}