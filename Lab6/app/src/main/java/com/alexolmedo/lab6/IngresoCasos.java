package com.alexolmedo.lab6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IngresoCasos extends AppCompatActivity {

    DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_casos);
    }

    public void botonIngresarCaso(View view){
        EditText id = findViewById(R.id.editTextID);
        EditText cliente = findViewById(R.id.editTextCliente);
        EditText fechaInicio = findViewById(R.id.editTextFechaInicio);
        EditText fechaFin = findViewById(R.id.editTextFechaFin);
        EditText estado = findViewById(R.id.editTextEstado);
        Log.d("Insert", "Datos: "+id.getText()+cliente.getText()+fechaInicio.getText()+fechaFin.getText()+estado.getText());
        db.addCaso(new Caso(Integer.parseInt(id.getText().toString()), cliente.getText().toString(),fechaInicio.getText().toString(),fechaFin.getText().toString(),estado.getText().toString()));
        Log.d("Insert", "Ingreso Correcto");
        Toast toast = Toast.makeText(getApplicationContext(), "Caso ingresado correctamente", Toast.LENGTH_SHORT);
        toast.show();
        Log.d("Busqueda", db.getCaso(Integer.parseInt(id.getText().toString())).toString());
        id.setText("");
        cliente.setText("");
        fechaInicio.setText("");
        fechaFin.setText("");
        estado.setText("");
    }
}
