package com.example.pre_examen.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuarioDbHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ", ";

    private static final String SQL_CREATE_USUARIO = "CREATE TABLE " +
            DefineTable.Usuarios.TABLE_NAME + " ( " +
            DefineTable.Usuarios.COLUMN_NAME_ID + " INTEGER PRIMARY KEY, " +
            DefineTable.Usuarios.COLUMN_NAME_CORREO + TEXT_TYPE + COMMA_SEP +
            DefineTable.Usuarios.COLUMN_NAME_CONTRA + TEXT_TYPE + " );";

    private static final String SQL_DELETE_USUARIO = "DROP TABLE IF EXISTS " +
            DefineTable.Usuarios.TABLE_NAME;

    private static final String DATABASE_NAME = "usuarios1.db";
    private static final int DATABASE_VERSION = 1;

    public UsuarioDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USUARIO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_USUARIO);
        onCreate(db);
    }
}
