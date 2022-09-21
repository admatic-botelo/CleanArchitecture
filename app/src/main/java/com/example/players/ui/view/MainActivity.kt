package com.example.players.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.players.databinding.ActivityMainBinding
import com.example.players.ui.viewmodel.PlayerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val playerViewModel: PlayerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        playerViewModel.onCreate()

        playerViewModel.playerModel.observe(this, Observer {
            binding.tvPlayerNumber.text = it.number
            binding.tvPlayerName.text = it.name
            binding.tvPlayerType.text = it.type
            Glide.with(this)
                .load(it.image)
                .into(binding.imgPlayer)
        })
        playerViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

        binding.viewContainer.setOnClickListener { playerViewModel.randomPlayer() }
    }
}