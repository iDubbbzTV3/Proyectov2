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

public class DinnerFragment extends Fragment {
    private static final String TAG = "DinnerFragment";

    private Button button;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cena, container, false);
        button = (Button) view.findViewById(R.id.button_shuffle_cena);
        textView = (TextView) view.findViewById(R.id.text_dinner);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int n = rand.nextInt(5);
                switch (n){
                    case 1:
                        textView.setText("*Seared Ahi Tuna Steak with Black\nPeppercorns and Wasabi (no mayo)\n*Jasmine Rice\n*Wilted Spinach\n*Bottle of Water");
                        break;
                    case 2:
                        textView.setText("*Lemon Filet of Sole\n*Wilted Garlic Spinach\n*Brown Rice\n*Bottle of Water");
                        break;
                    case 3:
                        textView.setText("*Grilled Pork Chop \n*Applesauce\n*Grilled Portobello Mushrooms\n*Baked Sweet Potato\n*Bottle of Water");
                        break;
                    case 4:
                        textView.setText("Grilled Halibut Steak w/ squeezed \nLemon\n*Brown Rice\n*Sauteed Spinach\n*Bottle of Water");
                        break;
                }              }
        });
        return view;
    }
}
