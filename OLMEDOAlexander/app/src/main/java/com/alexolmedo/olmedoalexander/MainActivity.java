package com.alexolmedo.olmedoalexander;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Nota> notas;
    DatabaseHandler db = new DatabaseHandler(this);
    TextView notasTotales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notas = db.getAllGrades();
        notasTotales = findViewById(R.id.textViewNotas);
        if (notas.isEmpty()) {
            notasTotales.setText("Notas Registradas: 0");
        } else {
            notasTotales.setText("Notas Registradas: " + notas.size());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        notas = db.getAllGrades();
        notasTotales = findViewById(R.id.textViewNotas);
        if (notas.isEmpty()) {
            notasTotales.setText("Notas Registradas: 0");
        } else {
            notasTotales.setText("Notas Registradas: " + notas.size());
        }
    }

    public void botonIngreso(View view) {
        Intent intent = new Intent(this, IngresoNotas.class);
        startActivity(intent);
    }

    public void botonConsulta(View view) {
        Intent intent = new Intent(this, ConsultaNotas.class);
        startActivity(intent);
    }
}
