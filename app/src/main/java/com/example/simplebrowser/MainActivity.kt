package com.example.simplebrowser

import android.content.Intent
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

        binding.google.setOnClickListener {
            val intent = Intent(this, GoogleActivity::class.java)
            startActivity(intent)
        }
        binding.yandex.setOnClickListener {
            val intent = Intent(this, YandexActivity::class.java)
            startActivity(intent)
        }
        binding.firefox.setOnClickListener {
            val intent = Intent(this, DuckDuckGoActivity::class.java)
            startActivity(intent)
        }
    }
}
