package com.example.tmaptest;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MemberJoinActivity extends AppCompatActivity {
    EditText editTextLoginId, editTextLoginPasswd, editTextLoginPasswdConfirm, editTextName, editTextPhoneNum;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_join);

        editTextLoginId = findViewById(R.id.editTextLoginId);//아이디 입력 EditText
        editTextLoginPasswd = findViewById(R.id.editTextLoginPasswd);//비밀번호 입력 EditText
        editTextLoginPasswdConfirm = findViewById(R.id.editTextLoginPasswdConfirm);//비밀전호 재입력 EditText
        editTextName = findViewById(R.id.editTextName);//이름 입력 EditText
        editTextPhoneNum = findViewById(R.id.editTextPhoneNum);//휴대폰 번호 입력 EditText

        // "가입" 버튼 클릭시 doJoin 실행
        findViewById(R.id.buttonDoJoin).setOnClickListener(view -> {
            doJoin();
        });
        //"취소"버튼 누르면 로그인 화면으로 다시 돌아감
        findViewById(R.id.buttonCancel).setOnClickListener(view -> {
            finish();
        });
    }
    // "가입" 버튼 클릭시 doJoin 실행되는 doJoin설정
    private void doJoin(){
        //공백 제거하여 생성
        String loginId = editTextLoginId.getText().toString().trim();
        String loginPasswd = editTextLoginPasswd.getText().toString().trim();
        String loginPasswdConfirm = editTextLoginPasswdConfirm.getText().toString().trim();
        String name = editTextName.getText().toString().trim();
        String PhoneNum = editTextPhoneNum.getText().toString().trim();

        //"가입"버튼 클릭시 이름을 입력하지 않았을 경우 토스트 메세지 출력
        if (name.length() == 0) {
            Toast.makeText(this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
            editTextName.requestFocus();
            return;
        }
        //"가입"버튼 클릭시 아이디를 입력하지 않았을 경우 토스트 메세지 출력
        if (loginId.length() == 0) {
            Toast.makeText(this, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
            editTextLoginId.requestFocus();
            return;
        }
        //"가입"버튼 클릭시 비밀번호를 입력하지 않았을 경우 토스트 메세지 출력
        if (loginPasswd.length() == 0) {
            Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
            editTextLoginPasswd.requestFocus();
            return;
        }
        //"가입"버튼 클릭시 비밀번호와 비밀번호 확인이 일치하지 않을 경우 토스트메세지 출력
        if (loginPasswd.equals(loginPasswdConfirm) == false) {
            Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            editTextLoginPasswdConfirm.requestFocus();
            return;
        }
        //"가입"버튼 클릭시 전화번호를 입력하지 않았을 경우 토스트 메세지 출력
        if (PhoneNum.length() == 0) {
            Toast.makeText(this, "전화번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
            editTextPhoneNum.requestFocus();
            return;
        }

        //AppDatabase의 findMember에서 아이디와 비밀번호 일치 유무 정보 가져오기
        Member member = AppDataBase.findMember(loginId);
        AppDataBase.join(loginId, loginPasswd, name);

        //member(가입된 회원 정보)에서 입력한 아이디가 존재하지 않으면 회원가입 정상적으로 진행
        //아이디가 존재하면 회원가입 되지 않음
        if (member != null) {
            editTextLoginId.requestFocus();
            return;
        }
        //가입 성공시 토스트 메세지 출력 후 로그인 화면으로 넘어감
        Toast.makeText(this, "가입 성공", Toast.LENGTH_SHORT).show();
        {finish();}
    }
}




/*
//아이디와 비밀번호가 일치하지 않을때 토스트 메세지 출력(출력 안됨...ㅜㅜ)
        if (member != null) {
                Toast.makeText(this, "이미 사용중인 아이디 입니다.", Toast.LENGTH_SHORT);
                editTextLoginId.requestFocus();
                return;
                }
                */
