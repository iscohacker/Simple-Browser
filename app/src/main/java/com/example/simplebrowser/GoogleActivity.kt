package com.example.simplebrowser

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.graphics.Bitmap
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simplebrowser.databinding.ActivityGoogleBinding

class GoogleActivity : AppCompatActivity() {
    private val binding by lazy { ActivityGoogleBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.webView.webViewClient = WebViewClient()

        binding.webView.settings.javaScriptEnabled = true

        binding.searchButton.setOnClickListener {
            val sorov = binding.editText.text.toString()
            val url = "https://www.google.com/search?q= $sorov"
            binding.webView.loadUrl(url)
        }
    }
}
