package com.alexolmedo.lab6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListaCasos extends AppCompatActivity {

    private DatabaseHandler db = new DatabaseHandler(this);
    public static final String CASE_ID = "id_caso";
    private List<Caso> casos;
    private ListView listViewCasos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_casos);
        listViewCasos = findViewById(R.id.listViewCasos);
        casos = db.getAllCases();

        ArrayAdapter<Caso> arrayAdapter = new ArrayAdapter<Caso>(this, R.layout.list_item, casos);
        listViewCasos.setAdapter(arrayAdapter);
    }
}
