package com.example.pre_examen;


import java.io.Serializable;

public class Usuario implements Serializable {
    public int id;
    public String usuario;
    public String correo;
    public String contra;

    public Usuario() {
        this.usuario = "";
        this.contra = "";
        this.correo = "";
    }

    public Usuario(int id, String usuario, String correo, String contra){
        this.id = id;
        this.usuario = usuario;
        this.correo = correo;
        this.contra = contra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
