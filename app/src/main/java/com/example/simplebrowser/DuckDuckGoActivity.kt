package com.example.simplebrowser

import android.app.ProgressDialog
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.simplebrowser.databinding.ActivityDuckDuckGoBinding

class DuckDuckGoActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDuckDuckGoBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.webView.webViewClient = WebViewClient()

        binding.webView.settings.javaScriptEnabled = true

        val dialog = ProgressDialog(this)
        dialog.setTitle("Ma'lumotlar yuklanmoqda...")
        dialog.setMessage("Iltimos, kuting")

        binding.webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                dialog.show()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                dialog.dismiss()
            }
        }
        binding.searchButton.setOnClickListener {
            val sorov = binding.editText.text.toString()
            val url = "https://duckduckgo.com/?t=h_&q= $sorov"
            binding.webView.loadUrl(url)
        }
        binding.remove.setOnClickListener {
            binding.editText.setText("")
        }
        binding.editText.addTextChangedListener {
            binding.remove.visibility = if (it.toString().isNotEmpty()) View.VISIBLE else View.GONE
        }
    }
}