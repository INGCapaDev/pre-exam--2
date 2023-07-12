package com.example.pre_examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pre_examen.modelo.UsuariosDb;

public class RegisterActivity extends AppCompatActivity {
    private EditText txtCorreo2, txtContra2, txtContraRep, txtUsuario;
    private Button btnRegresar, btnRegistro;
    private UsuariosDb usuariosDb;

    private boolean validar() {
        String correo = txtCorreo2.getText().toString();
        String contra = txtContra2.getText().toString();
        String contrarep = txtContraRep.getText().toString();
        String usuario = txtUsuario.getText().toString();

        if (correo.equals("")|| contra.equals("") || contrarep.equals("") || usuario.equals("")) {
            Toast.makeText(RegisterActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!contra.equals(contrarep)) {
            Toast.makeText(RegisterActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        usuariosDb = new UsuariosDb(this);
        txtCorreo2 = findViewById(R.id.txtCorreo2);
        txtContra2 = findViewById(R.id.txtContra2);
        txtContraRep = findViewById(R.id.txtContraRep);
        btnRegistro = findViewById(R.id.btnRegistro);
        btnRegresar = findViewById(R.id.btnRegresar);
        txtUsuario = findViewById(R.id.txtUsuario);



        btnRegistro.setOnClickListener(v -> {
            String correo = txtCorreo2.getText().toString();
            String contra = txtContra2.getText().toString();
            String usuario = txtUsuario.getText().toString();

            Usuario usuarioExistente = usuariosDb.getUsuario(correo);

            if (validar()) {
                if (usuarioExistente != null) {
                    Toast.makeText(RegisterActivity.this, "El correo ya existe", Toast.LENGTH_SHORT).show();
                } else {
                    Usuario nuevoUsuario = new Usuario();
                    nuevoUsuario.setUsuario(usuario);
                    nuevoUsuario.setCorreo(correo);
                    nuevoUsuario.setContra(contra);
                    long resultado = usuariosDb.insertUsuario(nuevoUsuario);
                    if (resultado > 0) {
                        Toast.makeText(RegisterActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Ocurrio un error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnRegresar.setOnClickListener(v -> {
            finish();
        });
    }
}