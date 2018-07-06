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
                int n = rand.nextInt(12);
                switch (n){
                    case 1:
                        textView.setText("1");
                        break;
                    case 2:
                        textView.setText("2");
                        break;
                    case 3:
                        textView.setText("3");
                        break;
                    case 4:
                        textView.setText("4");
                        break;
                    case 5:
                        textView.setText("5");
                        break;
                    case 6:
                        textView.setText("6");
                        break;
                    case 7:
                        textView.setText("7");
                        break;
                    case 8:
                        textView.setText("8");
                        break;
                    case 9:
                        textView.setText("9");
                        break;
                    case 10:
                        textView.setText("10");
                        break;
                    case 11:
                        textView.setText("11");
                        break;
                }
            }
        });
        return view;
    }
}
