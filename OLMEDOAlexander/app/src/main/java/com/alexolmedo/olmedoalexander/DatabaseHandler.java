package com.alexolmedo.olmedoalexander;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 20/12/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    //Versión de la base de datos
    private static final int DATABASE_VERSION = 1;

    //Nombre de la base de datos
    private static final String DATABASE_NAME = "gradesManager";

    //Nombre de la tabla de contactos
    private static final String TABLE_GRADES = "grades";

    //Nombres de las columnas de la tabla
    private static final String KEY_ID = "id";
    private static final String KEY_SUBJECT = "subject";
    private static final String KEY_GRADE = "grade";

    //Constructor de la base de datos
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_GRADES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_SUBJECT + " TEXT,"
                + KEY_GRADE + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GRADES);
        onCreate(db);
    }

    public void addGrade(Nota nota){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_SUBJECT, nota.getMateria());
        values.put(KEY_GRADE, nota.getNota());

        db.insert(TABLE_GRADES, null, values);
        db.close();
    }

    public Nota getGrade(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_GRADES, new
                String[]{KEY_ID,KEY_SUBJECT,KEY_GRADE}, KEY_ID+"=?",new
                String[]{String.valueOf(id)},null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }

        Nota nota = new Nota(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        return nota;
    }

    public List<Nota> getAllGrades(){
        List<Nota> gradeList = new ArrayList<Nota>();

        String sql_select = "SELECT * FROM " + TABLE_GRADES;

        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql_select,null);

        if(cursor.moveToFirst()){
            do{
                Nota nota = new Nota();
                nota.setCodigo(Integer.parseInt(cursor.getString(0)));
                nota.setMateria(cursor.getString(1));
                nota.setNota(cursor.getString(2));
                gradeList.add(nota);
            } while (cursor.moveToNext());
        }
        return gradeList;
    }


}