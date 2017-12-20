package com.alexolmedo.a20171102;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Recuperar el Intent de la actividad que dio inicio a esta actividad
        // Extraer el valor del mensaje con clave EXTRA_MESSAGE
        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);

        //Capturar el TextView de nuestra interfaz y modificar el texto
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);
    }
}
