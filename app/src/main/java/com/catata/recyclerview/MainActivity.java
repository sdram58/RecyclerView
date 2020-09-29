package com.catata.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.catata.recyclerview.adapters.MyAdapter;
import com.catata.recyclerview.modelos.Persona;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyAdapter myAdapter;
    RecyclerView rvLista;

    ArrayList<Persona> persona = new ArrayList<Persona>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ///Poblamos por código el Array
        persona.add(new Persona("Paco","Perez"));
        persona.add(new Persona("Sara","López"));
        persona.add(new Persona("Roberto","Brasero"));

        //Referenciamos el recyclerView

        rvLista = (RecyclerView) findViewById(R.id.lista);

        //Le indicamos que será una lista vertical (LinearLayout
        rvLista.setLayoutManager(new LinearLayoutManager(this));

        //Creamos un objeto de tipo MyAdapter al que le pasamos el contexto y el array de datos
        myAdapter = new MyAdapter(getApplicationContext(),persona);

        //Vinculamos el adaptador a la lista
        rvLista.setAdapter(myAdapter);



    }
    /*
    * Función que se ejecuta al realizar el evento onClick sobre el TexView superior
    * para probar a añadir datos a la lista
    * Para ell hacemos una llamada a la función setData de myAdapter
     */
    public void addPersona(View view) {

        Persona p = new Persona("Ana" , " Gonzalez");
        myAdapter.setData(p);
    }
}