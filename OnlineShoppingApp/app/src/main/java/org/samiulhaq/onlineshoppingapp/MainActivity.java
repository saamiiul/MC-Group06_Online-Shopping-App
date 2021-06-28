package org.samiulhaq.onlineshoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import org.samiulhaq.onlineshoppingapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());


    }
}