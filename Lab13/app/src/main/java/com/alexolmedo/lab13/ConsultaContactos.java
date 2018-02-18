package com.alexolmedo.lab13;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ConsultaContactos extends AppCompatActivity {

    private DatabaseHandler db = new DatabaseHandler(this);
    public static final String CONTACT_ID = "id_contacto";
    private List<Contacto> contactos;
    private ListView listViewContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_contactos);
        listViewContactos = findViewById(R.id.listViewContactos);
        contactos = db.getAllContacts();

        ArrayAdapter<Contacto> arrayAdapter = new ArrayAdapter<Contacto>(this, R.layout.list_item, contactos);
        listViewContactos.setAdapter(arrayAdapter);

        listViewContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String idCliente = String.valueOf(contactos.get(position).get_id());
                Intent intent = new Intent(getApplicationContext(), ResultadoConsulta.class );
                intent.putExtra(CONTACT_ID,idCliente);
                startActivity(intent);
            }
        });

    }
}
