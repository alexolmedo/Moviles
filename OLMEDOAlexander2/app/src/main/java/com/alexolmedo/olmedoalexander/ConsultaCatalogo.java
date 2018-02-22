package com.alexolmedo.olmedoalexander;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ConsultaCatalogo extends AppCompatActivity {

    private ListView listViewLibros;
    private ArrayList<String> listViewItems = new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    public static final String URL_LIBRO = "url_libro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_catalogo);

        listViewLibros = findViewById(R.id.listViewLibros);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listViewItems);
        listViewLibros.setAdapter(adapter);
        adapter.add("Thing Explainer");
        adapter.add("A Game of Thrones");
        adapter.add("The Lord of the Rings");
        adapter.notifyDataSetChanged();

        listViewLibros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = listViewItems.get(position);
                String url = "";

                switch (selected){
                    case "Thing Explainer":
                        url = "https://www.amazon.com/gp/product/0544668251/";
                        break;
                    case "A Game of Thrones":
                        url = "https://www.amazon.com/Game-Thrones-Song-Fire-Book/dp/0553593714/";
                        break;
                    case "The Lord of the Rings":
                        url = "https://www.amazon.com/Lord-Rings-50th-Anniversary-Vol/dp/0618640150/";
                        break;
                    default:
                        break;

                }

                Intent intent = new Intent(getApplicationContext(), DetalleLibro.class);
                intent.putExtra(URL_LIBRO,url);
                startActivity(intent);
            }
        });


    }
}
