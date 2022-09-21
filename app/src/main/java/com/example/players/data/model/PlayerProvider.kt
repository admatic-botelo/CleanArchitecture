package com.example.players.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerProvider @Inject constructor() {
    var players: List<PlayerModel> = emptyList()
}