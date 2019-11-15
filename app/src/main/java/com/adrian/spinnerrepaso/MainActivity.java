package com.adrian.spinnerrepaso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.adrian.spinnerrepaso.Adaptadores.AdaptadorPersona;
import com.adrian.spinnerrepaso.Utiles.Persona;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Spinner idspinneredad, idspinnerfinal;
    Button idbuttonañadir;
    CheckBox idcheckdisponibilidad;
    EditText ideditnombre, ideditapellido;
    // Spinner edad.
    ArrayList listaEdades;
    ArrayAdapter adaptadorSpinnerEdad;
    // Spìnner persona
    ArrayList listaPersonas;
    AdaptadorPersona adaptadorPersona;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        rellenarSpinnerEdad();
        acciones();
    }
    private void instancias(){
        idspinneredad = this.findViewById(R.id.idspinneredad);
        idspinnerfinal = this.findViewById(R.id.idspinnerfinal);
        ideditnombre = this.findViewById(R.id.ideditnombre);
        ideditapellido = this.findViewById(R.id.ideditapellido);
        idcheckdisponibilidad = this.findViewById(R.id.idcheckdisponibilidad);
        idbuttonañadir = this.findViewById(R.id.idbuttonañadir);
        // Spinner edad
        listaEdades = new ArrayList();
        adaptadorSpinnerEdad = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_item, listaEdades);
        // Spinner persona
        listaPersonas = new ArrayList();
        adaptadorPersona = new AdaptadorPersona(listaPersonas,getApplicationContext());
        idspinnerfinal.setAdapter(adaptadorPersona);

    }
    private void acciones(){
        idbuttonañadir.setOnClickListener(this);
        idspinneredad.setOnItemSelectedListener(this);
        idspinnerfinal.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idbuttonañadir:
                System.out.println("Cargando spinner...");
                System.out.println(adaptadorSpinnerEdad.getItem(idspinneredad.getSelectedItemPosition()));
                System.out.println("Agregando persona a spinner personalizado");
                agregarPersona();
                break;
        }
    }
    private void rellenarSpinnerEdad(){
        for (int i=18; i < 65; i++){
            listaEdades.add(i);
            adaptadorSpinnerEdad.notifyDataSetChanged();
        }
        idspinneredad.setAdapter(adaptadorSpinnerEdad);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       String edadSeleccionada = parent.getItemAtPosition(position).toString();
       Toast.makeText(getApplicationContext(),edadSeleccionada,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private void agregarPersona(){
        String edadPasar =  adaptadorSpinnerEdad.getItem(idspinneredad.getSelectedItemPosition()).toString();
        System.out.println(edadPasar);
        listaPersonas.add(new Persona(ideditnombre.getText().toString(),ideditapellido.getText().toString(),edadPasar));
        adaptadorPersona.notifyDataSetChanged();
    }
}
