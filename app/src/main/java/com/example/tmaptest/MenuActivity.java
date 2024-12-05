package com.example.tmaptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MenuActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageButton btnmenu = (ImageButton) findViewById(R.id.btnmenu);
        ImageButton btnguide = (ImageButton) findViewById(R.id.btnguide);
        ImageButton btnrent = (ImageButton) findViewById(R.id.rentbtn);

        //예약 버튼
        Button btnrent2 = (Button)findViewById(R.id.R_Rentbtn);
        //로그아웃 버튼
        Button btnLogout = (Button)findViewById(R.id.R_Logout);

        //메뉴 버튼 클릭
        btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent1);
            }
        });

        /*예약하기 버튼과 자전거 이미지 버튼을 통헤 예약할 수 있음*/
         // 자전거 모양 이미지 버튼
        btnrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), RentActivity.class);
                startActivity(intent2);
            }
        });
        //예약하기 버튼
        btnrent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplicationContext(), RentActivity.class);
                startActivity(intent3);
            }
        });

        //로그아웃 버튼
        btnLogout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(getApplicationContext(), MemberLoginActivity.class);
                startActivity(intent4);
                Toast.makeText(MenuActivity.this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        btnguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(getApplicationContext(), GuideActivity.class);
                startActivity(intent5);
            }
        });

    }
}

























