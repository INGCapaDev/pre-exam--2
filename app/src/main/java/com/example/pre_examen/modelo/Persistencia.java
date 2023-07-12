package com.example.pre_examen.modelo;

import com.example.pre_examen.Usuario;

public interface Persistencia {
    public void openDataBase();
    public void closeDataBase();
    public long insertUsuario(Usuario usuario);
    public long updateUsuario(Usuario usuario);
    public void deleteUsuario(int id);

}
