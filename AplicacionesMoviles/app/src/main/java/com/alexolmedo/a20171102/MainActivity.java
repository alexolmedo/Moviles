package com.alexolmedo.a20171102;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Método a ejecutarse cuando se da clic al botón send
    public void sendMessage(View view) {
        //Código a ejecutarse en respuesta al botón Sendhe
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key),Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString(getString(R.string.lastvalue), message);
        editor.commit();

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void lastValue(View view) {
//        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
//        String lastValue = sharedPref.getString(getString(R.string.lastvalue), "None");
//        TextView textView = (TextView) findViewById(R.id.lastTextView);
//        textView.setText(lastValue);

        SharedPreferences savedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String savedvalue =  savedPref.getString(getString(R.string.lastvalue),"None");
        TextView textView = (TextView) findViewById(R.id.lastTextView);
        textView.setText(savedvalue);
    }

    public void saveKeyValue(View view) {
        Intent intent = new Intent(this, LoadKeyValue.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key),Context.MODE_PRIVATE);
        if(!message.equals("")){
            SharedPreferences.Editor sharedEditor = sharedPref.edit();
            sharedEditor.putString(getString(R.string.lastvalue),message);
            sharedEditor.commit();
        }
        startActivity(intent);
    }

    public void openAboutMe(View view) {
        //Código a ejecutarse en respuesta al botón Send
        Intent intent = new Intent(this, DisplayImageActivity.class);
        startActivity(intent);
    }

}
