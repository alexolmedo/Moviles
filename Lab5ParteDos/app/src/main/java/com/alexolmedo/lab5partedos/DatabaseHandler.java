package com.alexolmedo.lab5partedos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 10/12/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    //Version de la base de datos
    public static final int DATABASE_VERSION = 1;

    //Nombre de la base de datos
    public static final String DATABASE_NAME = "contactsManager";

    //Nombre de la tabla de contactos
    public static final String TABLE_CONTACTS = "contacts";

    //Nombre de las columas de la tabla
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PH_NO = "phone_number";

    //Constructor de la base de datos
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(db);
    }

    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PH_NO, contact.getPhoneNumber());

        db.insert(TABLE_CONTACTS, null, values);
        db.close();
    }

    public Contact getContact(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new
        String[]{KEY_ID,KEY_NAME,KEY_PH_NO}, KEY_ID+"=?",new
        String[]{String.valueOf(id)},null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }

        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        return contact;
    }

    public List<Contact> getAllContacts(){
        List<Contact> contactList = new ArrayList<Contact>();

        String sql_select = "SELECT * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql_select,null);

        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                contactList.add(contact);
            }
        }
        return contactList;
    }

    public int updateContact(Contact contact){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PH_NO, contact.getPhoneNumber());

        return db.update(TABLE_CONTACTS, values, KEY_ID+"=?",
                new String[]{String.valueOf(contact.getId())});
    }

    public void deleteContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID+"=?",
                new String[]{String.valueOf(contact.getId())});
        db.close();
    }
}
