package com.example.monte.proyectov2;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EjerciciosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterRecEjercicios adapter;
    private List<ListaEjercicios> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        EditText editText = findViewById(R.id.edit_text);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        listItems = new ArrayList<>();

        ListaEjercicios listItem2 = new ListaEjercicios(
                "Marching Planks",
                "60 seconds"
        );
        listItems.add(listItem2);
        ListaEjercicios listItem3 = new ListaEjercicios(
                "Side Plank Lifts",
                "60 seconds"
        );
        listItems.add(listItem3);
        ListaEjercicios listItem4 = new ListaEjercicios(
                "Seated Ab Circles",
                "60 seconds"
        );
        listItems.add(listItem4);
        ListaEjercicios listItem5 = new ListaEjercicios(
                "90/90 Crunch",
                "30 seconds"
        );
        listItems.add(listItem5);
        ListaEjercicios listItem6 = new ListaEjercicios(
                "Russian V Tuck Twists",
                "30 seconds"
        );
        listItems.add(listItem6);
        ListaEjercicios listItem7 = new ListaEjercicios(
                "ISO Reverse Crunches",
                "30 seconds"
        );
        listItems.add(listItem7);
        ListaEjercicios listItem8 = new ListaEjercicios(
                "Bent Knee Windshield Wipers",
                "60 seconds"
        );
        listItems.add(listItem8);
        ListaEjercicios listItem9 = new ListaEjercicios(
                "Side Crunches",
                "60 seconds"
        );
        listItems.add(listItem9);
        ListaEjercicios listItem10 = new ListaEjercicios(
                "Jackknives",
                "30 seconds"
        );
        listItems.add(listItem10);

        adapter = new AdapterRecEjercicios(listItems, this);

        /*adapter.setOnItemClickListener(new AdapterRecEjercicios.OnClickListener() {
            @Override
            public void onItemClick(int position) {
                listItems.get(position);
                if (position == 0){
                    startActivity( new Intent(EjerciciosActivity.this, ActividadEjemplo1.class));
                }
                if (position == 1) {
                    startActivity( new Intent(EjerciciosActivity.this, ActividadEjemplo2.class));
                }
            }
        });*/

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
