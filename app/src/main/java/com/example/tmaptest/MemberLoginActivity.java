package com.example.tmaptest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MemberLoginActivity extends AppCompatActivity {
    EditText editTextLoginId, editTextLoginPasswd; //아이디과 비밀번호 입력창 EditText

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_login);

        editTextLoginId=findViewById(R.id.editTextLoginId); //아이디 입력 EditText
        editTextLoginPasswd=findViewById(R.id.editTextLoginPasswd); //비밀번호 입력 EditText

        // "로그인" 버튼 클릭시 doLogin 실행
        findViewById(R.id.buttonDoLogin).setOnClickListener(view -> {
            doLogin();
        });
        //"회원 가입" 버튼 누르면 회원가입 화면으로 넘어감
        findViewById(R.id.buttonJoin).setOnClickListener(view -> {
            startActivity(new Intent(MemberLoginActivity.this, com.example.tmaptest.MemberJoinActivity.class));
        });
    }
    //"로그인" 버튼 클릭시 실행되는 doLogin설정
    private void doLogin() {
        String loginId = editTextLoginId.getText().toString().trim(); //공백 제거하여 생성
        String loginPasswd = editTextLoginPasswd.getText().toString().trim(); //공백 제거하여 생성

        //아이디를 입력하지 않고 "로그인" 버튼 클릭시 토스트 메세지 출력
        if (loginId.length() == 0) {
            Toast.makeText(this, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
            editTextLoginId.requestFocus();
            return;
        }
        //비밀번호를 입력하지 않고 "로그인"버튼 클릭시 토스트 메세지 출력
        if (loginPasswd.length() == 0) {
            Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
            editTextLoginPasswd.requestFocus();
            return;
        }

        //AppDatabase.java(가상 데이터 생성 코드)의 findMember에서 아이디와 비밀번호 일치 유무 정보 가져오기
        //AppDatabase에는 아이디와 비밀번호가 일치하지 않으면 로그인이 실행되되지 않도록 설정되어 있음
        Member member = AppDataBase.findMember(loginId);


        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("loginedMemberId", member.getId());
        startActivity(intent);

    }
}


/*
//아이디와 비밀번호가 일치하지 않을때 토스트 메세지 출력(출력 안됨..ㅜㅜ)
        if (member == null) {
                Toast.makeText(this, "존재하지 않는 아이디 입니다.", Toast.LENGTH_SHORT);
                editTextLoginId.requestFocus();
                return;
                } else if (member.getLoginPasswd().equals(loginPasswd) == false) {
                Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT);
                editTextLoginPasswd.requestFocus();
                return;
                }

                //출력 안됨...ㅜㅜ
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT);

 */