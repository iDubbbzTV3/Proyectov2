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
                textView.setText("LAS PAPAYAS, LO LOGRE");
            }
        });
        return view;
    }
}
