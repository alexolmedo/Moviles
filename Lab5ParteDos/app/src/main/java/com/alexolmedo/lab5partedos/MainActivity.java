package com.alexolmedo.lab5partedos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);
        Log.d("Insert","Inserting...");
        db.addContact(new Contact("AAA","1233211232"));
        Log.d("Insert AAA","Success!");
        db.addContact(new Contact("BBB","9143493981"));
        Log.d("Insert BBB", "Success!");

        Log.d("Reading:", "Reading all contacts...");
        List<Contact> contacts = db.getAllContacts();
        for (Contact cn:contacts){
            String log = "ID: "+ cn.getId()+" ,Name: "+cn.getName()+" ,Phone: " + cn.getPhoneNumber();
            Log.d("Name: ", log);
        }

        Log.d("Update:", "AAA->CCC");
        Contact contact1 = db.getContact(2);
        Log.d("Old Contact",contact1.getName());
        contact1.setName("CCC");
        contact1.setPhoneNumber("321321321");
        Log.d("New Contact",contact1.getName());
        db.updateContact(contact1);

        Log.d("Deleting:", "Deleting all contacs...");
        for(Contact c : contacts){
            String log = "Id: " + c.getId()+" ,Name: " + c.getName() + " ,Phone: " +
                    c.getPhoneNumber();
            Log.d("Delete: ", log);
            db.deleteContact(c);
        }
    }
}
