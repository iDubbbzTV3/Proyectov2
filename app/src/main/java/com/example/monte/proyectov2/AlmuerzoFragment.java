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

public class AlmuerzoFragment extends Fragment {
    private static final String TAG = "AlmuerzoFragment";

    private Button button;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_almuerzo, container, false);
        button = (Button) view.findViewById(R.id.button_shuffle_almuerzo);
        textView = (TextView) view.findViewById(R.id.text_lunch);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int n = rand.nextInt(5);
                switch (n){
                    case 1:
                        textView.setText("*Pasta Salad with Citrus Grilled Chicken\nand Low-Fat Vinaigrette\n*Bottle of Water");
                        break;
                    case 2:
                        textView.setText("*Grilled Chicken on a Whole Wheat \nWrap with Lettuce, Tomato and Salsa\n*Fat Free Yogurt\n*Bottle of Water");
                        break;
                    case 3:
                        textView.setText("*Egg White and Pepper Omelet on a \nWhole Wheat Wrap with Fat Free\nSwiss Cheese\n*Fat Free Yogurt\n*Bottle of Water");
                        break;
                    case 4:
                        textView.setText("Turkey Breast on a Whole Wheat Wrap\n w/ Hot Mustard and Fat Free Swiss \n*Fat Free Yogurt\n*Bottle of Water");
                        break;
                }
            }
        });
        return view;
    }
}
