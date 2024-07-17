package com.example.simplebrowser

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.simplebrowser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val mediaPlayer =  MediaPlayer.create(this,R.raw.wosh)

        binding.google.setOnClickListener {
            mediaPlayer.start()
            val intent = Intent(this, GoogleActivity::class.java)
            startActivity(intent)
        }
        binding.yandex.setOnClickListener {
            mediaPlayer.start()
            val intent = Intent(this, YandexActivity::class.java)
            startActivity(intent)
        }
        binding.firefox.setOnClickListener {
            mediaPlayer.start()
            val intent = Intent(this, DuckDuckGoActivity::class.java)
            startActivity(intent)
        }
    }
}
