package com.example.pre_examen;


public class Usuario {
    public int id;
    public String correo;
    public String contra;

    public Usuario() {
        this.contra = "";
        this.correo = "";
    }

    public Usuario(int id, String correo, String contra){
        this.id = id;
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
}
