package com.example.players.domain

import com.example.players.data.PlayerRepository
import javax.inject.Inject

class GetPlayersUseCase @Inject constructor(private val repository : PlayerRepository) {
    suspend operator fun invoke() = repository.getAllPlayers()
}