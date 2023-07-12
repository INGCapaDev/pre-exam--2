package com.example.pre_examen.modelo;

import android.database.Cursor;

import com.example.pre_examen.Usuario;

import java.util.ArrayList;
import java.util.List;

public interface Proyeccion {
    public Usuario getUsuario(String correo);
    public List<Usuario> allUsuarios();
    public Usuario readUsuario(Cursor cursor);
}
