package com.example.monte.proyectov2;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class Alimentacion extends AppCompatActivity {

    private static final String TAG = "Alimentacion";
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentacion);
        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.viewpager_alimentacion);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout_alimentacion);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new DesayunoFragment(), "DESAYUNO");
        adapter.addFragment(new AlmuerzoFragment(), "ALMUERZO");
        adapter.addFragment(new DinnerFragment(), "DINNER");
        adapter.addFragment(new SnackFragment(), "SNACK");
        viewPager.setAdapter(adapter);
    }

}

