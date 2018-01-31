package com.alexolmedo.lab6;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

public class IngresoCasos extends AppCompatActivity {

    DatabaseHandler db = new DatabaseHandler(this);

    private EditText id;
    private EditText cliente;
    private EditText fechaInicio;
    private EditText fechaFin;
    private Spinner estado;
    private String fechaSelected;

    Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_casos);

        fechaInicio = findViewById(R.id.editTextFechaInicio);
        fechaFin = findViewById(R.id.editTextFechaFin);

        fechaInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(IngresoCasos.this, myDateListener, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                fechaInicio.setText(fechaSelected);
            }
        });

        fechaFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(IngresoCasos.this, myDateListener, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                fechaFin.setText(fechaSelected);
            }
        });
    }

    public void botonIngresarCaso(View view){
        id = findViewById(R.id.editTextID);
        cliente = findViewById(R.id.editTextCliente);
        fechaInicio = findViewById(R.id.editTextFechaInicio);
        fechaFin = findViewById(R.id.editTextFechaFin);
        estado = findViewById(R.id.spinnerEstado);
        Log.d("Insert", "Datos: "+id.getText()+cliente.getText()+fechaInicio.getText()+fechaFin.getText()+String.valueOf(estado.getSelectedItem()));
        db.addCaso(new Caso(Integer.parseInt(id.getText().toString()), cliente.getText().toString(),fechaInicio.getText().toString(),fechaFin.getText().toString(),String.valueOf(estado.getSelectedItem())));
        Log.d("Insert", "Ingreso Correcto");
        Toast toast = Toast.makeText(getApplicationContext(), "Caso ingresado correctamente", Toast.LENGTH_SHORT);
        toast.show();
        Log.d("Busqueda", db.getCaso(Integer.parseInt(id.getText().toString())).toString());
        id.setText("");
        cliente.setText("");
        fechaInicio.setText("");
        fechaFin.setText("");
        estado.setSelection(0);
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            fechaSelected = new StringBuilder().append(dayOfMonth).append("/").append(month+1).append("/").append(year).toString();
        }
    };

}
