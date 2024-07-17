package com.example.simplebrowser

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.simplebrowser.databinding.ActivityYandexBinding

class YandexActivity : AppCompatActivity() {
    private val binding by lazy { ActivityYandexBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.webView.webViewClient = WebViewClient()

        binding.webView.settings.javaScriptEnabled = true

        binding.searchButton.setOnClickListener {
            val sorov = binding.editText.text.toString()
            val url = "https://yandex.uz/search/?text= $sorov"
            binding.webView.loadUrl(url)
        }
    }
}