package com.adrian.spinnerrepaso.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.adrian.spinnerrepaso.R;
import com.adrian.spinnerrepaso.Utiles.Persona;

import java.util.ArrayList;

public class AdaptadorPersona extends BaseAdapter {
    // Var
    ArrayList listaDatos;
    Context context;
    // Constructor
    public AdaptadorPersona(ArrayList listaDatos, Context context) {
        this.listaDatos = listaDatos;
        this.context = context;
    }
    // Cuenta filas a poner
    @Override
    public int getCount() {
        return listaDatos.size();
    }
    // Retorna items
    @Override
    public Object getItem(int i) {
        return listaDatos.get(i);
    }
    // Retorna ids
    @Override
    public long getItemId(int i) {
        return i;
    }
    // Instancias

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.spinner_layout, viewGroup, false);
        //Persona
        Persona persona = (Persona) listaDatos.get(i);
        // Instancias
        TextView nombre = view.findViewById(R.id.idspinnernombre);
        TextView apellido = view.findViewById(R.id.idspinnerapellido);
        TextView edad = view.findViewById(R.id.idspinnertextedad);
        // Set
        nombre.setText(persona.getNombre());
        apellido.setText(persona.getApellido());
        edad.setText(persona.getEdad());
        // Return
        return view;
    }
}
