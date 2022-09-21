package com.example.players.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.players.data.model.PlayerModel
import com.example.players.domain.GetPlayersUseCase
import com.example.players.domain.GetRandomPlayerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val getPlayersUseCase: GetPlayersUseCase,
    private val getRandomPlayerUseCase: GetRandomPlayerUseCase
) : ViewModel() {

    val playerModel = MutableLiveData<PlayerModel>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getPlayersUseCase()

            if(!result.isNullOrEmpty()){
                playerModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomPlayer() {
        isLoading.postValue(true)
        val player = getRandomPlayerUseCase()
        if(player!=null){
            playerModel.postValue(player)
        }
        isLoading.postValue(false)
    }
}