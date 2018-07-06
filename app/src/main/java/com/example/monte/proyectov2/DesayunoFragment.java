package com.example.monte.proyectov2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class DesayunoFragment extends Fragment {
    private static final String TAG = "DesayunoFragment";

    private Button button;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_desayuno, container, false);
        button = (Button) view.findViewById(R.id.button_shuffle_desayuno);
        textView = (TextView) view.findViewById(R.id.text_breakfast);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int n = rand.nextInt(6);
                if(n==1)
                    textView.setText("1");
                if(n==2)
                    textView.setText("2");
                if(n==3)
                    textView.setText("3");
                if(n==4)
                    textView.setText("4");
                if(n==5)
                    textView.setText("5");
            }
        });
        return view;
    }
}
