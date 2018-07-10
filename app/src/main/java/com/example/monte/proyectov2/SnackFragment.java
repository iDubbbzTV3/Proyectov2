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

public class SnackFragment extends Fragment {
    private static final String TAG = "SnackFragment";

    private Button button;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_snack, container, false);
        button = (Button) view.findViewById(R.id.button_shuffle_snack);
        textView = (TextView) view.findViewById(R.id.text_snack);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int n = rand.nextInt(5);
                switch (n){
                    case 1:
                        textView.setText("*A Bag of Pretzels with Spicy Mustard\n*Fat Free Yogurt\n*Bottle of Water");
                        break;
                    case 2:
                        textView.setText("*Protein Shake OR \n*Air Popped Popcorn with Sprinkled\nParmesan Cheese\n*Bottle of Water");
                        break;
                    case 3:
                        textView.setText("*Peanut Butter\n*Sliced Green Apple\n*Bottle of Water");
                        break;
                    case 4:
                        textView.setText("Turkey / Beef Jerky \n*Saltine Crackers\n*Bottle of Water");
                        break;
                }
            }
        });
        return view;
    }
}
