package com.example.whatsapp;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class Main6Activity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        bottomNavigationView = findViewById(R.id.bnvv);
        viewPager = findViewById(R.id.view);
        b1 = findViewById(R.id.button4);
        b2 = findViewById(R.id.button5);




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main6Activity.this, Main9Activity.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main6Activity.this, Main7Activity.class);
                startActivity(intent);
            }
        });

        Pageview pageview = new Pageview(getSupportFragmentManager());
        viewPager.setAdapter(pageview);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                switch (i){
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.item7);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.item8);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.item9);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.item,menu);
        return true;
    }
}
