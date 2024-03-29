package com.alexolmedo.lab7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> listViewItems = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.mainListView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listViewItems);
        listView.setAdapter(adapter);
        adapter.add("Thing 1");
        adapter.add("Thing 2");
        adapter.add("Thing 3");
        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = listViewItems.get(position);
//                Toast.makeText(getApplicationContext(),"Clic en el número " + position, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),selected, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
