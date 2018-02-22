package com.alexolmedo.olmedoalexander;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class UsuarioLogin extends AppCompatActivity {

    private Button btnLoginUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_login);
        btnLoginUsuario = findViewById(R.id.btnLoginUsuario);

        btnLoginUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ConsultaCatalogo.class);
                startActivity(intent);
            }
        });
    }
}
