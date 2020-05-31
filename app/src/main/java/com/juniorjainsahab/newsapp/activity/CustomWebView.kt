package com.juniorjainsahab.newsapp.activity

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.juniorjainsahab.newsapp.R

class CustomWebView : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_web_view)

        webView = findViewById(R.id.web_view)
        webView.loadUrl(intent.getStringExtra("url"))

        webView.webViewClient = object : InsideWebViewClient() {}
    }

    open class InsideWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url)
            return true
        }
    }
}