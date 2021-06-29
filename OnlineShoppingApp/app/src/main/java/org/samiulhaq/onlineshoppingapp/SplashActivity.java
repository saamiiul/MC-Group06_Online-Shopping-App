package org.samiulhaq.onlineshoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(100);
        progressBar.setProgress(0);
        Thread thread=new Thread(){
            @Override
            public void run(){
                try {
                    for (int i=0;i<100;i++){
                        progressBar.setProgress(i);
                        sleep(20);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Intent intentLoading=new Intent(getApplicationContext(),MainPage.class);
                    startActivity(intentLoading);
                    finish();
                }
            }
        };
        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentRun= new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intentRun);
                finish();
            }
        },7000);
    }
}
