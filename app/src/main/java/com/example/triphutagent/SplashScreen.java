package com.example.triphutagent;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        changeStatusBarColor();



        Thread thread = new Thread() {

            public void run() {

                try {
                    sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();

                } finally {
                    Intent intent = new Intent(SplashScreen.this, Admin.class);
                    startActivity(intent);
                    finish();
                }
            }
        };thread.start();
    }

    private void changeStatusBarColor() {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));
        }
    }
}