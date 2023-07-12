package com.example.pre_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pre_examen.modelo.UsuariosDb;

public class MainActivity extends AppCompatActivity {

    private EditText txtCorreo, txtContra;
    private Button btnIngresar, btnRegistrarse;
    private UsuariosDb usuariosDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuariosDb = new UsuariosDb(this);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtContra = findViewById(R.id.txtContra);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);

        btnIngresar.setOnClickListener(v -> {
            String correo = txtCorreo.getText().toString();
            String contra = txtContra.getText().toString();

            Usuario usuario = usuariosDb.getUsuario(correo);

            if (usuario != null && usuario.getContra().equals(contra)){
                Toast.makeText(MainActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Datos incorrectos o no esta registrado", Toast.LENGTH_SHORT).show();

            }


        });

        btnRegistrarse.setOnClickListener(v -> {
            String correo = txtCorreo.getText().toString();
            String contra = txtContra.getText().toString();

            Usuario usuarioExistente = usuariosDb.getUsuario(correo);

            if (usuarioExistente != null) {
                Toast.makeText(MainActivity.this, "El correo ya existe", Toast.LENGTH_SHORT).show();
            } else {
                Usuario nuevoUsuario = new Usuario();
                nuevoUsuario.setCorreo(correo);
                nuevoUsuario.setContra(contra);
                long resultado = usuariosDb.insertUsuario(nuevoUsuario);
                if (resultado > 0) {
                    Toast.makeText(MainActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Ocurrio un error", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}