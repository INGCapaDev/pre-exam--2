package com.example.pre_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });




    }
}