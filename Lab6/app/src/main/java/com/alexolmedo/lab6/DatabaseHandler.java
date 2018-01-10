package com.alexolmedo.lab6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 19/12/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper{
    //Version de la base de datos
    public static final int DATABASE_VERSION = 1;

    //Nombre de la base de datos
    public static final String DATABASE_NAME = "expedientesManager";

    //Nombre de la tabla de contactos
    public static final String TABLE_CASES = "expedientes";

    //Nombre de las columas de la tabla
    public static final String KEY_ID = "id";
    public static final String KEY_CLIENT = "cliente";
    public static final String KEY_START_DATE = "fechaInicio";
    public static final String KEY_END_DATE = "fechaFin";
    public static final String KEY_STATE = "estado";

    //Constructor de la base de datos
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CASES_TABLE = "CREATE TABLE " + TABLE_CASES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_CLIENT + " TEXT,"
                + KEY_START_DATE + " TEXT," + KEY_END_DATE + " TEXT,"
                + KEY_STATE + " TEXT" + ")";
        db.execSQL(CREATE_CASES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CASES);
        onCreate(db);
    }

    public void addCaso(Caso caso){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, caso.get_id());
        values.put(KEY_CLIENT, caso.get_cliente());
        values.put(KEY_START_DATE, caso.get_fechaInicio());
        values.put(KEY_END_DATE, caso.get_fechaFin());
        values.put(KEY_STATE, caso.get_estado());

        db.insert(TABLE_CASES, null, values);
        db.close();
    }

    public Caso getCaso(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_CASES, new
                String[]{KEY_ID,KEY_CLIENT,KEY_START_DATE,KEY_END_DATE,KEY_STATE}, KEY_ID+"=?",new
                String[]{String.valueOf(id)},null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }

        Caso caso = new Caso(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                cursor.getString(2),cursor.getString(3),cursor.getString(4));

        return caso;
    }

    public List<Caso> getAllCases(){
        List<Caso> caseList = new ArrayList<Caso>();

        String sql_select = "SELECT * FROM " + TABLE_CASES;

        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql_select,null);

        if(cursor.moveToFirst()){
            do{
                Caso caso = new Caso(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                        cursor.getString(2),cursor.getString(3),cursor.getString(4));
                caseList.add(caso);
            } while (cursor.moveToNext());
        }
        return caseList;
    }
}
