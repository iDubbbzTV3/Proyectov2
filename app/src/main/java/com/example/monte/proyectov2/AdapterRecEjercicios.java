package com.example.monte.proyectov2;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecEjercicios extends RecyclerView.Adapter<AdapterRecEjercicios.ViewHolder> {

    private List<ListaEjercicios> listItems;
    private Context context;
    private OnClickListener mListener;

    public interface OnClickListener{
        void onItemClick (int position);
    }

    public void setOnItemClickListener(OnClickListener listener){
        mListener = listener;
    }

    public AdapterRecEjercicios(List<ListaEjercicios> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_ejercicios, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final ListaEjercicios listItem = listItems.get(position);

        holder.textViewHead.setText(listItem.getHead());
        holder.textViewDesc.setText(listItem.getDesc());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listItem.getHead().equals("Jackknives")){
                    Intent openThree = new Intent(context,ActividadEjemplo1.class);
                    context.startActivity(openThree);
                }
                if(listItem.getHead().equals("Marching Planks")){
                    Intent openThree = new Intent(context,ActividadEjemplo2.class);
                    context.startActivity(openThree);
                }
                if(listItem.getHead().equals("Side Plank Lifts")){
                    Intent openThree = new Intent(context,ActividadEjemplo3.class);
                    context.startActivity(openThree);
                }
                if(listItem.getHead().equals("Seated Ab Circles")){
                    Intent openThree = new Intent(context,ActividadEjemplo4.class);
                    context.startActivity(openThree);
                }
                if(listItem.getHead().equals("90/90 Crunch")){
                    Intent openThree = new Intent(context,ActividadEjemplo5.class);
                    context.startActivity(openThree);
                }
                if(listItem.getHead().equals("Russian V Tuck Twists")){
                    Intent openThree = new Intent(context,ActividadEjemplo6.class);
                    context.startActivity(openThree);
                }
                if(listItem.getHead().equals("ISO Reverse Crunches")){
                    Intent openThree = new Intent(context,ActividadEjemplo7.class);
                    context.startActivity(openThree);
                }
                if(listItem.getHead().equals("Bent Knee Windshield Wipers")){
                    Intent openThree = new Intent(context,ActividadEjemplo8.class);
                    context.startActivity(openThree);
                }
                if(listItem.getHead().equals("Side Crunches")){
                    Intent openThree = new Intent(context,ActividadEjemplo9.class);
                    context.startActivity(openThree);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHead;
        public TextView textViewDesc;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

                textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
                textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
                linearLayout = (LinearLayout) itemView.findViewById(R.id.linear_layout);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mListener != null){
                            int position = getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION){
                                mListener.onItemClick(position);
                            }
                        }
                    }
                });

        }
    }

    public void filterList(ArrayList<ListaEjercicios> filteredList){
        listItems = filteredList;
        notifyDataSetChanged();
    }

}
