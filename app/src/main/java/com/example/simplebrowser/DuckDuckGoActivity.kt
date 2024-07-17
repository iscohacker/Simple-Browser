package com.example.simplebrowser

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.simplebrowser.databinding.ActivityDuckDuckGoBinding

class DuckDuckGoActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDuckDuckGoBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.webView.webViewClient = WebViewClient()

        binding.webView.settings.javaScriptEnabled = true

        binding.searchButton.setOnClickListener {
            val sorov = binding.editText.text.toString()
            val url = "https://duckduckgo.com/?t=h_&q= $sorov"
            binding.webView.loadUrl(url)
        }
    }
}