package com.alexolmedo.lab6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class ResultadoBusqueda extends AppCompatActivity {

    DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_busqueda);

        Intent intent = getIntent();
        String idBuscado = intent.getStringExtra(ConsultaCasos.CASE_ID);

        Caso casoBuscado = db.getCaso(Integer.parseInt(idBuscado));
        Log.d("Busqueda", casoBuscado.toString());

        TextView id = findViewById(R.id.editTextID);
        TextView cliente = findViewById(R.id.editTextCliente);
        TextView fechaInicio = findViewById(R.id.editTextFechaInicio);
        TextView fechaFin = findViewById(R.id.editTextFechaFin);
        TextView estado = findViewById(R.id.editTextEstado);

        id.setText(String.valueOf(casoBuscado.get_id()));
        cliente.setText(casoBuscado.get_cliente());
        fechaInicio.setText(casoBuscado.get_fechaInicio());
        fechaFin.setText(casoBuscado.get_fechaFin());
        estado.setText(casoBuscado.get_estado());
    }
}
