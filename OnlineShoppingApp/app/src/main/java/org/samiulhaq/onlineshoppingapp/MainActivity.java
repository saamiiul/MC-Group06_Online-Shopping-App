<<<<<<< HEAD
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
=======
package org.samiulhaq.onlineshoppingapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import org.samiulhaq.onlineshoppingapp.Adapters.MainItemsAdapter;
import org.samiulhaq.onlineshoppingapp.Models.MainItemsModel;
import org.samiulhaq.onlineshoppingapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());


    }
>>>>>>> 2521da4e5c958924e9dc36c6b2f9edd26ac88543
}