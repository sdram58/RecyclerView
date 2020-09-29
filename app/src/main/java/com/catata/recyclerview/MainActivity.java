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

        persona.add(new Persona("Paco","Perez"));
        persona.add(new Persona("Sara","López"));
        persona.add(new Persona("Roberto","Brasero"));

        rvLista = (RecyclerView) findViewById(R.id.lista);

        rvLista.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter(getApplicationContext(),persona);

        rvLista.setAdapter(myAdapter);



    }

    public void addPersona(View view) {

        Persona p = new Persona("Ana" , " Gonzalez");
        myAdapter.setData(p);
    }
}