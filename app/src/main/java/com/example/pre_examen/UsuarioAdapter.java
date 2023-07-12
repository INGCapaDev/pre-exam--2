package com.example.pre_examen;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;


public class UsuarioAdapter extends BaseAdapter  {

  Context context;
  List<Usuario> lst;

  public UsuarioAdapter(Context context, List<Usuario> lst) {
      this.context = context;
      this.lst = lst;
    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView TextViewUsuario, TextViewCorreo;

        Usuario c = lst.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.usuario_item, null);
        }

        TextViewCorreo = convertView.findViewById(R.id.textViewCorre);
        TextViewUsuario = convertView.findViewById(R.id.textViewUsuario);

        TextViewCorreo.setText(c.correo);
        TextViewUsuario.setText(c.usuario);

        return convertView;
    }
}
