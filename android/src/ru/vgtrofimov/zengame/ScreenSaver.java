package ru.vgtrofimov.zengame;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ScreenSaver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_saver);

        Intent intent = new Intent(this, AndroidLauncher.class);
        ScreenSaver screenSaver = this;

        new CountDownTimer(750, 750) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                        screenSaver.finish();
                    }
                });

            }
        }.start();

    }
}