package com.juniorjainsahab.newsapp.activity

import android.os.Bundle
import android.view.Window
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.juniorjainsahab.newsapp.R
import kotlinx.android.synthetic.main.activity_main.*

class CustomWebView : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_PROGRESS)
        setContentView(R.layout.activity_custom_web_view)

        webView = findViewById(R.id.web_view)
        webView.settings.javaScriptEnabled
        webView.settings.builtInZoomControls
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.loadUrl(intent.getStringExtra("url"))

        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                setProgress(newProgress * 100)
            }
        }

        webView.webViewClient = object : InsideWebViewClient() {}
    }

    open class InsideWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url)
            return true
        }
    }
}