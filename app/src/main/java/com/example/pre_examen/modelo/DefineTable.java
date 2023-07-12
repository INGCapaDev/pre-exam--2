package com.example.pre_examen.modelo;

import android.provider.BaseColumns;

public class DefineTable implements BaseColumns {
    public DefineTable(){}

    public static abstract class Usuarios {
        public static final String TABLE_NAME = "usuarios";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_CORREO = "correo";
        public static final String COLUMN_NAME_CONTRA = "contra";

        public static String[] REGISTRO = new String[]{
                Usuarios.COLUMN_NAME_ID,
                Usuarios.COLUMN_NAME_CORREO,
                Usuarios.COLUMN_NAME_CONTRA
        };
    }
}
