package com.alexolmedo.lab13;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private DatabaseHandler db = new DatabaseHandler(this);
    private Button botonConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonConsulta = findViewById(R.id.btnConsulta);
        botonConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ConsultaContactos.class);
                startActivity(intent);
            }
        });
        consultContacts();
    }

    public void consultContacts(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api.androidhive.info/contacts/";
        final JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new
                        Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONObject jsonObj = new
                                            JSONObject(response.toString());
                                    JSONArray contacts = jsonObj.getJSONArray("contacts");
                                    for (int i = 0; i < contacts.length(); i++) {
                                        JSONObject c = contacts.getJSONObject(i);
                                        String id = c.getString("id");
                                        String name = c.getString("name");
                                        String email = c.getString("email");
                                        String address = c.getString("address");
                                        String gender = c.getString("gender");
                                        Log.d("Contacto", id+name+email+address+gender);
                                        db.addContacto(new Contacto(id,name,email,address,gender));
                                    }
                                }
                                catch (final JSONException e) {
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Volley", "That didn't work!");
                    }
                });
        queue.add(jsObjRequest);
    }
}
