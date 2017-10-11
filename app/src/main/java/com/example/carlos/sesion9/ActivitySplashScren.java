package com.example.carlos.sesion9;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.carlos.sesion9.beans.User;

import java.util.Timer;
import java.util.TimerTask;

public class ActivitySplashScren extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_scren);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                User user = new User().getUser(ActivitySplashScren.this);
                Intent intent;
                if( user.isLogged() ){
                    //user is logged
                    intent = new Intent(ActivitySplashScren.this, ActivityMain.class);
                }else{
                    intent = new Intent(ActivitySplashScren.this, ActivityLogin.class);
                }
                startActivity(intent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 3000);
    }
}
