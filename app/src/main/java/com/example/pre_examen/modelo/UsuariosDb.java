package com.example.pre_examen.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pre_examen.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuariosDb implements Persistencia, Proyeccion {

    private Context context;
    private UsuarioDbHelper helper;
    private SQLiteDatabase db;

    public UsuariosDb(Context context, UsuarioDbHelper helper){
        this.context = context;
        this.helper = helper;
    }

    public UsuariosDb(Context context){
        this.context = context;
        this.helper = new UsuarioDbHelper(this.context);
    }

    @Override
    public void openDataBase() {
        db = helper.getWritableDatabase();
    }

    @Override
    public void closeDataBase() {
        helper.close();
    }

    @Override
    public long insertUsuario(Usuario usuario) {
        ContentValues values = new ContentValues();

        values.put(DefineTable.Usuarios.COLUMN_NAME_CORREO, usuario.getCorreo());
        values.put(DefineTable.Usuarios.COLUMN_NAME_CONTRA, usuario.getContra());

        this.openDataBase();
        long num = db.insert(DefineTable.Usuarios.TABLE_NAME, null, values);
        return num;
    }

    @Override
    public long updateUsuario(Usuario usuario) {
        ContentValues values = new ContentValues();

        values.put(DefineTable.Usuarios.COLUMN_NAME_ID, usuario.getId());
        values.put(DefineTable.Usuarios.COLUMN_NAME_CORREO, usuario.getCorreo());
        values.put(DefineTable.Usuarios.COLUMN_NAME_CONTRA, usuario.getContra());

        this.openDataBase();
        long num = db.update(
                DefineTable.Usuarios.TABLE_NAME,
                values,
                DefineTable.Usuarios.COLUMN_NAME_ID + " = " + usuario.getId(),
                null);
        return num;
    }

    @Override
    public void deleteUsuario(int id) {
        this.openDataBase();
        db.delete(
                DefineTable.Usuarios.TABLE_NAME,
                DefineTable.Usuarios.COLUMN_NAME_ID + "=?",
                new String[] {String.valueOf(id)}
        );
    }

    @Override
    public Usuario getUsuario(String correo) {
        db = helper.getWritableDatabase();

        Cursor cursor = db.query(
                DefineTable.Usuarios.TABLE_NAME,
                DefineTable.Usuarios.REGISTRO,
                DefineTable.Usuarios.COLUMN_NAME_CORREO + "=?",
                new String[] {correo},
                null, null, null

        );

        if (cursor.moveToFirst()) {
            Usuario usuario = readUsuario(cursor);
            cursor.close();
            return usuario;
        } else {
            cursor.close();
            return null;
        }
    }

    @Override
    public List<Usuario> allUsuarios() {
        db = helper.getWritableDatabase();
        Cursor cursor = db.query(
                DefineTable.Usuarios.TABLE_NAME,
                DefineTable.Usuarios.REGISTRO,
                null, null, null, null, null
        );
        List<Usuario> usuarios = new ArrayList<>();
        
        while (!cursor.isAfterLast()) {
            Usuario usuario = readUsuario(cursor);
            usuarios.add(usuario);
            cursor.moveToNext();
            
        }
        cursor.close();
        return usuarios;
    }

    @Override
    public Usuario readUsuario(Cursor cursor) {
        Usuario usuario = new Usuario();

        usuario.setId(cursor.getInt(0));
        usuario.setCorreo(cursor.getString(1));
        usuario.setContra(cursor.getString(2));

        return usuario;
    }
}
