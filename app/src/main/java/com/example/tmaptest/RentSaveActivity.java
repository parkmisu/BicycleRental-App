package com.example.tmaptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RentSaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_save);

        //선택된 대여소, 자전거, 시간 텍스트로 가져오기
        Intent it1=getIntent();
        String  PlaceOptions = it1.getStringExtra("it1_place");
        String  BikeOptions = it1.getStringExtra("it1_bike");

        TextView PlaceSave = (TextView)findViewById(R.id.PlaceSave);
        TextView BikeSave = (TextView) findViewById(R.id.BikeSave);
        TextView TimeSave = (TextView)findViewById(R.id.TimeSave);

        Button R_OKbtn = (Button)findViewById(R.id.R_OKbtn);
        Button R_Cancelbtn = (Button)findViewById(R.id.R_Cancelbtn);

        TimeSave.setText(it1.getStringExtra("it1_time"));

        //대여소 선택시
        if(PlaceOptions.equals("서울역 9번 출구")){
            PlaceSave.setText("서울역 9번 출구");
        }else if(PlaceOptions.equals("서울역 4번 출구")){
            PlaceSave.setText("서울역 4번 출구");
        }else if(PlaceOptions.equals("서울역 3번 출구")){
            PlaceSave.setText("서울역 3번 출구");
        }else if(PlaceOptions.equals("SK 남산빌딩")){
            PlaceSave.setText("SK 남산빌딩");
        }else if(PlaceOptions.equals("서울역 서부차로2")){
            PlaceSave.setText("서울역 서부차로2");
        }else if(PlaceOptions.equals("도동삼거리")){
            PlaceSave.setText("도동삼거리");
        }else if(PlaceOptions.equals("브라운스톤 남산 아파트")){
            PlaceSave.setText("브라운스톤 남산 아파트");
        }else if(PlaceOptions.equals("염천교 사거리")){
            PlaceSave.setText("염천교 사거리");
        }else if(PlaceOptions.equals("종로학원본원")){
            PlaceSave.setText("종로학원본원");
        }else if(PlaceOptions.equals("대한상공회의소")){
            PlaceSave.setText("대한상공회의소");
        }else if(PlaceOptions.equals("호암아트홀")){
            PlaceSave.setText("호암아트홀");
        }else if(PlaceOptions.equals("청파동입구 교차로")){
            PlaceSave.setText("청파동입구 교차로");
        }else if(PlaceOptions.equals("서울역 센트럴 자이 아파트")){
            PlaceSave.setText("서울역 센트럴 자이 아파트");
        }else if(PlaceOptions.equals("SK 리체블")){
            PlaceSave.setText("SK 리체블");
        }else if(PlaceOptions.equals("충정2교")){
            PlaceSave.setText("충정2교");
        }else if(PlaceOptions.equals("회현역 7번 출구")){
            PlaceSave.setText("회현역 7번 출구");
        }else if(PlaceOptions.equals("회현역 1번 출구")){
            PlaceSave.setText("회현역 1번 출구");
        }


        //자전거 선택시
        if(BikeOptions.equals("자전거1")) {
            BikeSave.setText("자전거1");
        }else if(BikeOptions.equals("자전거2")){
            BikeSave.setText("자전거2");
        }else if(BikeOptions.equals("자전거3")){
            BikeSave.setText("자전거3");
        }else if(BikeOptions.equals("자전거4")){
            BikeSave.setText("자전거4");
        }else if(BikeOptions.equals("자전거5")){
            BikeSave.setText("자전거5");
        } else if(BikeOptions.equals("자전거6")){
            BikeSave.setText("자전거6");
        }else if(BikeOptions.equals("자전거7")){
            BikeSave.setText("자전거7");
        }else if(BikeOptions.equals("자전거8")){
            BikeSave.setText("자전거8");
        }else if(BikeOptions.equals("자전거9")){
            BikeSave.setText("자전거9");
        }else if(BikeOptions.equals("자전거10")){
            BikeSave.setText("자전거10");
        }else if(BikeOptions.equals("자전거11")){
            BikeSave.setText("자전거11");
        }else if(BikeOptions.equals("자전거12")){
            BikeSave.setText("자전거12");
        }else if(BikeOptions.equals("자전거13")){
            BikeSave.setText("자전거13");
        }else if(BikeOptions.equals("자전거14")){
            BikeSave.setText("자전거14");
        }else if(BikeOptions.equals("자전거15")){
            BikeSave.setText("자전거15");
        }

        //예약 취소 버튼 클릭시
        R_Cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlaceSave.setText("예약 정보 없음");
                BikeSave.setText("예약 정보 없음");
                TimeSave.setText("예약 정보 없음");
                Toast.makeText(RentSaveActivity.this, "예약이 취소되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        //확인 버튼 클릭시 이전 화면으로(메뉴 화면 or main 화면)
        R_OKbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RentSaveActivity.this, MainActivity.class));
            }
        });
    }

}