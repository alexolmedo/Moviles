package com.alexolmedo.lab13;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class ResultadoConsulta extends AppCompatActivity {

    DatabaseHandler db = new DatabaseHandler(this);
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_consulta);

        Intent intent = getIntent();
        String idBuscado = intent.getStringExtra(ConsultaContactos.CONTACT_ID);

        Contacto contactoBuscado = db.getContacto(idBuscado);
        Log.d("Busqueda", contactoBuscado.toString());

        TextView id = findViewById(R.id.editTextID);
        TextView name = findViewById(R.id.editTextName);
        TextView email = findViewById(R.id.editTextEmail);
        TextView address = findViewById(R.id.editTextAddress);
        TextView gender = findViewById(R.id.editTextGender);

        id.setText(String.valueOf(contactoBuscado.get_id()));
        name.setText(contactoBuscado.get_name());
        email.setText(contactoBuscado.get_email());
        address.setText(contactoBuscado.get_address());
        gender.setText(contactoBuscado.get_gender());
    }
}
