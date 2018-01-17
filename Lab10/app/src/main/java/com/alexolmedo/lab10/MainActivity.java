package com.alexolmedo.lab10;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button buttonEscoger;
    private Button buttonListas;
    private Calendar calendar;
    private TextView dateView;
    private int year;
    private int month;
    private int day;
    private Spinner spinner1;
    private Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEscoger = findViewById(R.id.buttonEscoger);
        buttonEscoger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDate(buttonEscoger);
            }
        });

        dateView = findViewById(R.id.dateView);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        addItemsSpinner2();

        buttonListas = findViewById(R.id.buttonListSubmit);
        buttonListas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setList(buttonListas);
            }
        });

    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "Ejemplo de calendario", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            showDate(year, month+1, dayOfMonth);
        }
    };

    private void showDate(int year, int month, int dayOfMonth){
        dateView.setText(new StringBuilder().append(dayOfMonth).append("/").append(month).append("/").append(year));
    }

    public void addItemsSpinner2(){
        spinner2 = findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        list.add("item 1");
        list.add("item 2");
        list.add("item 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        spinner2.setAdapter(dataAdapter);
    }

    public void setList(View view){
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        Toast.makeText(getApplicationContext(), "OnClickListener: " +
        "\nSpinner1: "+String.valueOf(spinner1.getSelectedItem())+
        "\nSpinner2: "+String.valueOf(spinner2.getSelectedItem()), Toast.LENGTH_SHORT).show();
    }
}
