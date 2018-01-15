package com.alexolmedo.a20171102;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DisplayImageActivity extends AppCompatActivity {

    private Button buttonDetalles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);
        Intent intent = getIntent();

        buttonDetalles = findViewById(R.id.buttonDetalles);
        buttonDetalles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ControlWeb.class);
                startActivity(intent);
            }
        });

    }
}
