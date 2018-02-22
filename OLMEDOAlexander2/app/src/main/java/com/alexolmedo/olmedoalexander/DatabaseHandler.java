package com.alexolmedo.olmedoalexander;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper{
    //Version de la base de datos
    public static final int DATABASE_VERSION = 1;

    //Nombre de la base de datos
    public static final String DATABASE_NAME = "usuariosManager";

    //Nombre de la tabla de usuarios
    public static final String TABLE_CASES = "usuarios";

    //Nombre de las columas de la tabla
    public static final String KEY_USER = "usuario";
    public static final String KEY_NAME = "nombre";
    public static final String KEY_BIRTH_DATE = "fechaNacimiento";
    public static final String KEY_CI = "cedula";
    public static final String KEY_PASSWORD = "password";

    //Constructor de la base de datos
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CASES_TABLE = "CREATE TABLE " + TABLE_CASES + "("
                + KEY_USER + " TEXT PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_BIRTH_DATE + " TEXT," + KEY_CI + " TEXT,"
                + KEY_PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_CASES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CASES);
        onCreate(db);
    }

    public void addUsuario(Usuario usuario){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USER, usuario.get_usuario());
        values.put(KEY_NAME, usuario.get_nombre());
        values.put(KEY_BIRTH_DATE, usuario.get_fechaNacimiento());
        values.put(KEY_CI, usuario.get_cedula());
        values.put(KEY_PASSWORD, usuario.get_password());

        db.insert(TABLE_CASES, null, values);
        db.close();
    }

    public Usuario getUsuario(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_CASES, new
                String[]{KEY_USER, KEY_NAME, KEY_BIRTH_DATE, KEY_CI, KEY_PASSWORD}, KEY_USER +"=?",new
                String[]{String.valueOf(id)},null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }

        Usuario usuario = new Usuario(cursor.getString(0), cursor.getString(1),
                cursor.getString(2),cursor.getString(3),cursor.getString(4));

        return usuario;
    }

    public List<Usuario> getAllUsers(){
        List<Usuario> userList = new ArrayList<Usuario>();

        String sql_select = "SELECT * FROM " + TABLE_CASES;

        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql_select,null);

        if(cursor.moveToFirst()){
            do{
                Usuario caso = new Usuario(cursor.getString(0), cursor.getString(1),
                        cursor.getString(2),cursor.getString(3),cursor.getString(4));
                userList.add(caso);
            } while (cursor.moveToNext());
        }
        return userList;
    }
}
