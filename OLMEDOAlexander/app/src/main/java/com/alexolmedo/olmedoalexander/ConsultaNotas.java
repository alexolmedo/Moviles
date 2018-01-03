package com.alexolmedo.olmedoalexander;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class ConsultaNotas extends AppCompatActivity {

    DatabaseHandler db = new DatabaseHandler(this);

    EditText id;
    EditText materia;
    EditText nota;

    List<Nota> notas;
    int indice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_notas);
        indice = 0;
        notas = db.getAllGrades();

        id = findViewById(R.id.editTextIDResultado);
        materia = findViewById(R.id.editTextMateriaResultado);
        nota = findViewById(R.id.editTextNotaResultado);

        if (notas.isEmpty()){
            Toast toast = Toast.makeText(getApplicationContext(), "No existen registros", Toast.LENGTH_SHORT);
            toast.show();
            Button anterior = findViewById(R.id.buttonAnterior);
            Button siguiente = findViewById(R.id.buttonSiguiente);
            anterior.setEnabled(false);
            siguiente.setEnabled(false);
        } else {
            Nota actual = notas.get(indice);
            id.setText(String.valueOf(actual.getCodigo()));
            materia.setText(actual.getMateria());
            nota.setText(actual.getNota());
        }
    }

    public void botonAnterior(View view) {
        id = findViewById(R.id.editTextIDResultado);
        materia = findViewById(R.id.editTextMateriaResultado);
        nota = findViewById(R.id.editTextNotaResultado);

        if (indice > 0) {
            indice -= 1;
            Nota actual = notas.get(indice);
            id.setText(String.valueOf(actual.getCodigo()));
            materia.setText(actual.getMateria());
            nota.setText(actual.getNota());
        } else {
            Nota actual = notas.get(indice);
            id.setText(String.valueOf(actual.getCodigo()));
            materia.setText(actual.getMateria());
            nota.setText(actual.getNota());
            Toast toast = Toast.makeText(getApplicationContext(), "Se llegó al principio de la lista", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    public void botonSiguiente(View view) {
        if (indice < notas.size() - 1) {
            id = findViewById(R.id.editTextIDResultado);
            materia = findViewById(R.id.editTextMateriaResultado);
            nota = findViewById(R.id.editTextNotaResultado);
            indice += 1;
            Nota actual = notas.get(indice);
            id.setText(String.valueOf(actual.getCodigo()));
            materia.setText(actual.getMateria());
            nota.setText(actual.getNota());
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Se llegó al fin de la lista", Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}
