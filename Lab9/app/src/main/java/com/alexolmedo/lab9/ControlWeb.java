package com.alexolmedo.lab9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class ControlWeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_web);

        WebView webView = findViewById(R.id.webView);
        webView.loadUrl("http://fis.epn.edu.ec/");
    }
}
