package com.alexolmedo.olmedoalexander;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class DetalleLibro extends AppCompatActivity {

    private WebView webViewLibro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_libro);

        Intent intent = getIntent();
        String urlLibro = intent.getStringExtra(ConsultaCatalogo.URL_LIBRO);

        webViewLibro = findViewById(R.id.webViewLibro);
        webViewLibro.loadUrl(urlLibro);
    }
}
