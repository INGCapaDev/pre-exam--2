package com.example.pre_examen;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pre_examen.modelo.UsuariosDb;

import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ListView listViewUsuarios;
    private UsuariosDb usuariosDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listViewUsuarios = findViewById(R.id.listViewUsuarios);
        usuariosDb = new UsuariosDb(this);


        List<Usuario> listaUsuarios = usuariosDb.allUsuarios();
        UsuarioAdapter adapter = new UsuarioAdapter(this, listaUsuarios);

        listViewUsuarios.setAdapter(adapter);
    }


}
