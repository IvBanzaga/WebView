package com.vanzaga.webview;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityWeb extends AppCompatActivity {

    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_web);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        web = findViewById(R.id.webView);

        String sitio_web = getIntent().getStringExtra("sitio_web");

        // Para navegar dentro de nuestra aplicacion
        web.setWebViewClient(new WebViewClient());

        // Para navegar fuera de nuestra aplicacion
        // web.setWebCromeClient(new WebViewClient());

        // Para cargar la url usaremos
        web.loadUrl("https://" + sitio_web);
    }

    public void cerrar (View view) {
        finish();
    }
}