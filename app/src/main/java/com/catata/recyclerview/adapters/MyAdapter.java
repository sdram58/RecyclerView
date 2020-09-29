package com.catata.recyclerview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.catata.recyclerview.R;
import com.catata.recyclerview.modelos.Persona;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Persona> personas;

    //Creamos un constructor donde recibiremos el contexto de la aplicación así como los datos que formarán parte de la lista
    public MyAdapter(Context context, ArrayList<Persona> personas) {
        this.context = context;
        this.personas = personas;
    }
    public void setData(Persona p){
        personas.add(0,p);

        //Notificamos que los datos de la lista han cambiado.
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Creamos un objeto de tipo View el cual lo inflamos para que contenga el layout item_list
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_list, parent, false);
        //Devolvemos un holder pasándole como parámetro la vista creada.
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {

        //Ponemos la información en las vistas en función de la posición de la lista/array
        holder.tvNombre.setText(personas.get(i).getNombre());
        holder.tvApellido.setText(personas.get(i).getApellido());


        //Creamos un manejador de onClick para el elemento
        holder.tvNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView t = (TextView)view;
                Toast.makeText(context,"has pulsado nombre : " + t.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        //Creamos tantas variables como elementos tenga la vista que queramos vincular
        public TextView tvNombre, tvApellido;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre = (TextView)itemView.findViewById(R.id.nombre);
            tvApellido = (TextView)itemView.findViewById(R.id.apellidos);
        }
    }
}
