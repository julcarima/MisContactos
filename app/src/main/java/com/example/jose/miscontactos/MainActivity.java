package com.example.jose.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<contacto> contactos;
    private RecyclerView listaContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);


        listaContactos = (RecyclerView) findViewById(R.id.rvConatctos);

        /*LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);*/
        GridLayoutManager glm = new GridLayoutManager(this, 2);

        listaContactos.setLayoutManager(glm);
        inicializarListaContactos();
        inicializaAdaptador();


        /*
        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());
                startActivity(intent);
                finish();
                
            }
        });

        */
    }

    public ContactoAdaptador adaptador;
    public void inicializaAdaptador(){
        adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);
    }



    public void inicializarListaContactos(){
        contactos = new ArrayList<contacto>();

        contactos.add(new contacto(R.drawable.images,"José Miguel", "926238344", "josejulcarima@hotmail.com"));
        contactos.add(new contacto(R.drawable.imagess,"Miguel", "9950164647", "Miguel@hotmail.com"));
        contactos.add(new contacto(R.drawable.girl_anime_kawaii_render_by_nardhipster_d6p4iyf,"Vilma", "924633614", "Vilma@hotmail.com"));
        contactos.add(new contacto(R.drawable.girl_anime_kawaii_render_by_nardhipster_d6p4iyf,"Cery", "999120095", "Cery@hotmail.com"));
    }
}

