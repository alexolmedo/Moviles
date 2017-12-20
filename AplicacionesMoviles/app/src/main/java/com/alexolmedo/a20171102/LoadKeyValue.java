package com.alexolmedo.a20171102;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class LoadKeyValue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_key_value);
    }

    public void loadKeyValue(View view){
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String lastvalue =  sharedPref.getString(getString(R.string.lastvalue),"None");
        TextView textView = (TextView) findViewById(R.id.textViewShared);
        textView.setText(lastvalue);
    }
}
