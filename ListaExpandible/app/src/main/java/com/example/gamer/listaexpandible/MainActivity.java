package com.example.gamer.listaexpandible;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
        ExpandableListView miexpandible;
        ExpandibleAdapter miadapter;
        ArrayList<String> listacategoria;
    Map<String , ArrayList<String>> mapchild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miexpandible= (ExpandableListView)findViewById(R.id.expandiblelv);
        listacategoria= new ArrayList<>();
        mapchild = new HashMap<>();
        caragrdatos();

    }

    private void caragrdatos(){
        //creando las listas de categorias
        ArrayList<String> listaaves= new ArrayList<>();
        ArrayList<String> listamamiferos= new ArrayList<>();
        ArrayList<String> listareptiles= new ArrayList<>();
        ArrayList<String> listapeces= new ArrayList<>();
        listacategoria.add("aves");
        listacategoria.add("mamifereos");
        listacategoria.add("reptiles");
        listacategoria.add("peces");

        listaaves.add("loro");
        listaaves.add("aguila");
        listaaves.add("condor");

        listamamiferos.add("perro");
        listamamiferos.add("gato");
        listamamiferos.add("vaca");
        listamamiferos.add("conejo");

        listareptiles.add("lagarto");
        listareptiles.add("caiman");
        listareptiles.add("dragon de comodo");
        listareptiles.add("lagartija");
        listareptiles.add("camaleon");
        listareptiles.add("iguana");

        listapeces.add("jurel");
        listapeces.add("bonito");

        //enlasando
        mapchild.put(listacategoria.get(0),listaaves);
        mapchild.put(listacategoria.get(1),listamamiferos);
        mapchild.put(listacategoria.get(2),listareptiles);
        mapchild.put(listacategoria.get(3),listapeces);

        miadapter = new ExpandibleAdapter( listacategoria, mapchild ,this );
        miexpandible.setAdapter(miadapter);
    }
}
