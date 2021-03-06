package com.example.monte.proyectov2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Day1 extends Fragment {

    private RecyclerView recyclerView;
    private AdapterRecEjercicios adapter;
    private List<ListaEjercicios> listItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.day_1, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerDias);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        listItems = new ArrayList<>();

        final ListaEjercicios listItem1 = new ListaEjercicios(
                "Hands Back Tucks",
                "30 seconds"
        );
        listItems.add(listItem1);
        ListaEjercicios listItem2 = new ListaEjercicios(
                "Marching Planks",
                "60 seconds"
        );
        listItems.add(listItem2);
        ListaEjercicios listItem3 = new ListaEjercicios(
                "Side Plank Lifts",
                "30 seconds"
        );
        listItems.add(listItem3);
        ListaEjercicios listItem4 = new ListaEjercicios(
                "Rest",
                "45 seconds"
        );
        listItems.add(listItem4);
        ListaEjercicios listItem5 = new ListaEjercicios(
                "Seated Ab Circles",
                "60 seconds"
        );
        listItems.add(listItem5);
        ListaEjercicios listItem6 = new ListaEjercicios(
                "90/90 Crunch",
                "30 seconds"
        );
        listItems.add(listItem6);
        ListaEjercicios listItem7 = new ListaEjercicios(
                "Russian V Tuck Twists",
                "30 seconds"
        );
        listItems.add(listItem7);

        adapter = new AdapterRecEjercicios(listItems, getContext());

        adapter.setOnItemClickListener(new AdapterRecEjercicios.OnClickListener() {
            @Override
            public void onItemClick(int position) {
                listItems.get(position);
                /*
                if (position == 0){
                    startActivity( new Intent(getContext(), ActividadEjemplo1.class));
                }
                if (position == 1) {
                    startActivity( new Intent(getContext(), ActividadEjemplo2.class));
                }
                */
            }
        });

        recyclerView.setAdapter(adapter);
        return view;
    }
}
