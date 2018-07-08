package com.example.monte.proyectov2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class ListaDiariaEjercicios extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterRecEjercicios adapter;
    private List<ListaEjercicios> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day_1);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerDias);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        final ListaEjercicios listItem1 = new ListaEjercicios(
                "patadas1",
                "y no patatas"
        );
        listItems.add(listItem1);
        ListaEjercicios listItem2 = new ListaEjercicios(
                "patadas2",
                "y no patatas"
        );
        listItems.add(listItem2);
        ListaEjercicios listItem3 = new ListaEjercicios(
                "3",
                "y no patatas"
        );
        listItems.add(listItem3);
        ListaEjercicios listItem4 = new ListaEjercicios(
                "patadas4",
                "y no patatas"
        );
        listItems.add(listItem4);
        ListaEjercicios listItem5 = new ListaEjercicios(
                "patadas5",
                "y no patatas"
        );
        listItems.add(listItem5);
        ListaEjercicios listItem6 = new ListaEjercicios(
                "patadas6",
                "y no patatas"
        );
        listItems.add(listItem6);
        ListaEjercicios listItem7 = new ListaEjercicios(
                "patadas7",
                "y no patatas"
        );
        listItems.add(listItem7);
        ListaEjercicios listItem8 = new ListaEjercicios(
                "patadas8",
                "y no patatas"
        );
        listItems.add(listItem8);
        final ListaEjercicios listItem = new ListaEjercicios(
                "patadas9",
                "y no patatas"
        );
        listItems.add(listItem);
        ListaEjercicios listItem9 = new ListaEjercicios(
                "patadas10",
                "y no patatas"
        );
        listItems.add(listItem9);
        ListaEjercicios listItem10 = new ListaEjercicios(
                "patadas11",
                "y no patatas"
        );
        listItems.add(listItem10);
        ListaEjercicios listItem11 = new ListaEjercicios(
                "patadas12",
                "y no patatas"
        );
        listItems.add(listItem11);
        ListaEjercicios listItem12 = new ListaEjercicios(
                "patadas13",
                "y no patatas"
        );
        listItems.add(listItem12);
        ListaEjercicios listItem13 = new ListaEjercicios(
                "patadas14",
                "y no patatas"
        );
        listItems.add(listItem13);
        ListaEjercicios listItem14 = new ListaEjercicios(
                "patadas15",
                "y no patatas"
        );
        listItems.add(listItem14);

        adapter = new AdapterRecEjercicios(listItems, this);

        adapter.setOnItemClickListener(new AdapterRecEjercicios.OnClickListener() {
            @Override
            public void onItemClick(int position) {
                listItems.get(position);
                if (position == 0){
                    startActivity( new Intent(ListaDiariaEjercicios.this, ActividadEjemplo1.class));
                }
                if (position == 1) {
                    startActivity( new Intent(ListaDiariaEjercicios.this, ActividadEjemplo2.class));
                }
            }
        });

        recyclerView.setAdapter(adapter);
    }

    private void filter(String text){
        ArrayList<ListaEjercicios> filteredList = new ArrayList<>();

        for(ListaEjercicios item : listItems){
            if(item.getHead().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }

}
