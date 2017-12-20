package com.alexolmedo.olmedoalexander;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class IngresoNotas extends AppCompatActivity {

    DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_notas);
    }

    public void botonIngresarNota(View view){
        EditText materia = findViewById(R.id.editTextMateriaIngreso);
        EditText nota = findViewById(R.id.editTextNotaIngreso);

        db.addGrade(new Nota(materia.getText().toString(), nota.getText().toString()));

        materia.setText("");
        nota.setText("");

        Log.d("Busqueda", db.getGrade(1).toString());
    }
}
