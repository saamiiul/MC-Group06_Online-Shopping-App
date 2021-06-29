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

        ArrayList<MainItemsModel> itemList= new ArrayList<>();
        itemList.add(new MainItemsModel(R.drawable.tshirts,"TShirts"));
        itemList.add(new MainItemsModel(R.drawable.sports,"Sports"));
        itemList.add(new MainItemsModel(R.drawable.female_dresses,"Female Dresses"));
        itemList.add(new MainItemsModel(R.drawable.sweather,"Sweaters"));
        itemList.add(new MainItemsModel(R.drawable.mobiles,"Mobiles"));
        itemList.add(new MainItemsModel(R.drawable.glasses,"Glasses"));
        itemList.add(new MainItemsModel(R.drawable.shoess,"Shoes"));
        itemList.add(new MainItemsModel(R.drawable.purses_bags,"Bags"));
        itemList.add(new MainItemsModel(R.drawable.laptops,"Laptops"));
        itemList.add(new MainItemsModel(R.drawable.headphoness,"HeadPhones"));

        MainItemsAdapter mainItemsAdapter= new MainItemsAdapter(itemList,this);
        mainBinding.MainItemsRecyclerView.setAdapter(mainItemsAdapter);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        mainBinding.MainItemsRecyclerView.setLayoutManager(gridLayoutManager);

        mainBinding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mainItemsAdapter.getFilter().filter(newText.toString());
                return false;
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void ShowNotification() {
        int notifyID = 1;
        String CHANNEL_ID = "my_channel_01";
        CharSequence name = getString(R.string.channel_name);
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
        Notification notification = new Notification.Builder(MainActivity.this)
                .setContentTitle("Champs")
                .setContentText("You are at right place. Order what you like.")
                .setSmallIcon(R.drawable.sbag)
                .setChannelId(CHANNEL_ID)
                .build();

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(mChannel);

        notificationManager.notify(1, notification);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    protected void onStart()
    {
        super.onStart();
        ShowNotification();
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Exit")
                .setIcon(R.drawable.warning)
                .setMessage("Are you sure you want to Exit")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNeutralButton("help", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Open help Activity",Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).show();
    }
}