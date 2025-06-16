package com.example.recetasexpress

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class RecipeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        val webView: WebView = findViewById(R.id.webView)

        // Habilitar JavaScript y forzar carga dentro del WebView
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        // Cargar una URL (puedes cambiarla por un archivo local o receta)
        webView.loadUrl("https://www.youtube.com/watch?v=S8SuH7V199A")
    }
}
