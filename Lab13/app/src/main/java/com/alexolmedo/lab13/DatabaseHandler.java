package com.alexolmedo.lab13;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 18/2/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper{
    //Version de la base de datos
    public static final int DATABASE_VERSION = 1;

    //Nombre de la base de datos
    public static final String DATABASE_NAME = "contactosManager";

    //Nombre de la tabla de contactos
    public static final String TABLE_CASES = "contactos";

    //Nombre de las columas de la tabla
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_GENDER = "gender";

    //Constructor de la base de datos
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CASES_TABLE = "CREATE TABLE " + TABLE_CASES + "("
                + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT," + KEY_ADDRESS + " TEXT,"
                + KEY_GENDER + " TEXT" + ")";
        db.execSQL(CREATE_CASES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CASES);
        onCreate(db);
    }

    public void addContacto(Contacto contacto){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, contacto.get_id());
        values.put(KEY_NAME, contacto.get_name());
        values.put(KEY_EMAIL, contacto.get_email());
        values.put(KEY_ADDRESS, contacto.get_address());
        values.put(KEY_GENDER, contacto.get_gender());

        db.insert(TABLE_CASES, null, values);
        db.close();
    }

    public Contacto getContacto(String id){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_CASES, new
                String[]{KEY_ID, KEY_NAME, KEY_EMAIL,KEY_ADDRESS, KEY_GENDER}, KEY_ID+"=?",new
                String[]{String.valueOf(id)},null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }

        Contacto contacto = new Contacto(cursor.getString(0), cursor.getString(1),
                cursor.getString(2),cursor.getString(3),cursor.getString(4));

        return contacto;
    }

    public List<Contacto> getAllContacts(){
        List<Contacto> caseList = new ArrayList<Contacto>();

        String sql_select = "SELECT * FROM " + TABLE_CASES;

        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql_select,null);

        if(cursor.moveToFirst()){
            do{
                Contacto contacto = new Contacto(cursor.getString(0), cursor.getString(1),
                        cursor.getString(2),cursor.getString(3),cursor.getString(4));
                caseList.add(contacto);
            } while (cursor.moveToNext());
        }
        return caseList;
    }
}
