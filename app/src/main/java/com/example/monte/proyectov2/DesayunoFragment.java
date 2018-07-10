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
                int n = rand.nextInt(5);
                switch (n){
                    case 1:
                        textView.setText("*Protein Shake");
                        break;
                    case 2:
                        textView.setText("*Whole Wheat Waffles w/ Applesauce \n*High Grade Omega-3's\nProtein Shake");
                        break;
                    case 3:
                        textView.setText("*Whole Wheat Toast\n*Egg White Souffle (5 Egg Whites Mixed\nin a Glass Bowl Microwave on High for\n4 minutes)\n*High Grade Omega-3's");
                        break;
                    case 4:
                        textView.setText("Bowl of Oatmeal (add Cinamon + \nWalnuts)\n*Glass of Skim Milk\n*Scrambled Egg Whites with Salsa\n*High Grade Omega-3's");
                        break;
                }
            }
        });
        return view;
    }
}
