package com.alexolmedo.lab6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void botonIngreso(View view) {
        Intent intent = new Intent(this, IngresoCasos.class);
        startActivity(intent);
    }

    public void botonConsulta(View view) {
        Intent intent = new Intent(this, ListaCasos.class);
        startActivity(intent);
    }
}
