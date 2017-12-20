package com.alexolmedo.olmedoalexander;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
    }

    public void botonAnterior(View view){
        id = findViewById(R.id.editTextIDResultado);
        materia = findViewById(R.id.editTextMateriaResultado);
        nota = findViewById(R.id.editTextNotaResultado);

        if (indice>0){
            indice-=1;
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

    public void botonSiguiente(View view){
        id = findViewById(R.id.editTextIDResultado);
        materia = findViewById(R.id.editTextMateriaResultado);
        nota = findViewById(R.id.editTextNotaResultado);
        indice+=1;
        Nota actual = notas.get(indice);
        id.setText(String.valueOf(actual.getCodigo()));
        materia.setText(actual.getMateria());
        nota.setText(actual.getNota());

    }
}
