package com.alexolmedo.lab6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class ConsultaCasos extends AppCompatActivity {
    public static final String CASE_ID = "id_caso";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_casos);
    }

    public void botonResultadoConsulta(View view) {
        EditText id = findViewById(R.id.editTextIDConsulta);
        Intent intent = new Intent(this, ResultadoBusqueda.class );
        intent.putExtra(CASE_ID,id.getText().toString());
        startActivity(intent);
    }
}
