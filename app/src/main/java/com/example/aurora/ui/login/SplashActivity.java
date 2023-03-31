package com.example.aurora.ui.login;

import static com.example.aurora.ui.login.StandaardValues.getlogin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aurora.R;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);
        TextView txt = findViewById(R.id.txt);


        AlphaAnimation animation1 = new AlphaAnimation(0.0f, 1.0f);
        animation1.setDuration(1500);
        animation1.setFillAfter(false);
        txt.startAnimation(animation1);
        Context c = getApplicationContext();
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        Intent k = new Intent();
                        if (!getlogin(c)) {
                            k.setClass(SplashActivity.this, LoginActivity.class);
                        } else {
                            k.setClass(SplashActivity.this, DataUI.class);
                        }
                        k.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(k);
                        finish();
                    }
                }, 2000);


    }
}


















