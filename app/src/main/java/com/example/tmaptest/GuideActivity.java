package com.example.tmaptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class GuideActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        ImageButton btnmenu = (ImageButton) findViewById(R.id.btnmenu);
        ImageButton btnguide = (ImageButton) findViewById(R.id.btnguide);
        ImageButton btnrent = (ImageButton) findViewById(R.id.rentbtn);

        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });


        btnrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), RentActivity.class);
                startActivity(intent1);
            }
        });

    }
}