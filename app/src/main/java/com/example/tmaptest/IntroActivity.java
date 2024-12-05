package com.example.tmaptest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class IntroActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introactivity);

        com.example.tmaptest.IntroThread introThread = new com.example.tmaptest.IntroThread(handler);
        introThread.start();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                Intent intent = new Intent(IntroActivity.this, MemberLoginActivity.class);
                startActivity(intent);
            }
        }
    };
}
