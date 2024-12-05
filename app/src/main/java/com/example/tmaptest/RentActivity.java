package com.example.tmaptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class RentActivity  extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);

        //Button placebtn = (Button) findViewById(R.id.placebtn);
        //Button bikebtn = (Button) findViewById(R.id.bikebtn);
        Button cancelbtn = (Button) findViewById(R.id.returnbtn1);
        Button okbtn = (Button) findViewById(R.id.okbtn1);

        //Spinner 설정을 위함
        Spinner PlaceSpinner = (Spinner) findViewById(R.id.PlaceSpinner);
        Spinner BikeSpinner = (Spinner) findViewById(R.id.BikeSpinner);
        //시간 설정을 위함
        TimePicker TimeSpinner = findViewById(R.id.TimeSpinner);
        TextView TimeTextView = findViewById(R.id.TimeTextView);

        //스피너 시도2
        //대여소 선택 스피너
        ArrayAdapter<CharSequence>adapter1 = ArrayAdapter.createFromResource(this, R.array.PlaceOptions, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        PlaceSpinner.setAdapter(adapter1);

        //자전거 선택 스피너
        ArrayAdapter<CharSequence>adapter2 = ArrayAdapter.createFromResource(this, R.array.BikeOptions, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        BikeSpinner.setAdapter(adapter2);

        //타임피커 시간 텍스트로 저장
        TimeSpinner.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
                TimeTextView.setText(hour + "시" + minute + "분");
            }
        });

        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent3);
            }
        });

        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //스피너 선택 값 넘기기
                String PlaceOptions = PlaceSpinner.getSelectedItem().toString();
                String BikeOptions = BikeSpinner.getSelectedItem().toString();
                String TimeOptions = TimeTextView.getText().toString();

                Intent it1 = new Intent(getApplicationContext(),RentSaveActivity.class);
                it1.putExtra("it1_place", PlaceOptions);
                it1.putExtra("it1_bike", BikeOptions);
                it1.putExtra("it1_time",TimeOptions);
                startActivity(it1);

                Toast.makeText(RentActivity.this, "예약 완료", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
