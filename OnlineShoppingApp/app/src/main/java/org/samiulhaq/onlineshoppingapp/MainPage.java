package org.samiulhaq.onlineshoppingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import org.samiulhaq.onlineshoppingapp.Adapters.MainAdapter;
import org.samiulhaq.onlineshoppingapp.Models.MainModel;
import org.samiulhaq.onlineshoppingapp.databinding.ActivityMainPageBinding;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {

    ActivityMainPageBinding mainPageBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainPageBinding=ActivityMainPageBinding.inflate(getLayoutInflater());
        setContentView(mainPageBinding.getRoot());
        ArrayList<MainModel> list=new ArrayList<>();
        Bundle bundle=getIntent().getExtras();
        if(bundle.getString("name").equals("T-Shirts")){
            list.add(new MainModel(R.drawable.tshirt1,"Black and Red","1000","US Polo"));
            list.add(new MainModel(R.drawable.tshirt2,"Printed","1500","US Polo"));
            list.add(new MainModel(R.drawable.tshirt3,"Gray","3000","US Polo"));
        }
        else if(bundle.getString("name").equals("Sports")){
            list.add(new MainModel(R.drawable.sports1,"Blue","1000","Without name"));
            list.add(new MainModel(R.drawable.sports2,"Printed","1500","With name"));
            list.add(new MainModel(R.drawable.sports3,"White","3000","With Piping"));
        }
        else if(bundle.getString("name").equals("Female Dresses")){
            list.add(new MainModel(R.drawable.girls1,"Shalawar Qamees","1000","Lawn"));
            list.add(new MainModel(R.drawable.girls2,"Frock","1500","Party Wear"));
            list.add(new MainModel(R.drawable.girls3,"Lehnga","3000","Party Wear"));
        }
        else if(bundle.getString("name").equals("Sweaters")){
            list.add(new MainModel(R.drawable.coat1,"Medium Coat","1000","Borjan"));
            list.add(new MainModel(R.drawable.coat2,"Short Coat","1500","Borjan"));
            list.add(new MainModel(R.drawable.coat3,"Medium Coat","3000","Borjan"));
        }
        else if(bundle.getString("name").equals("Mobiles")){
            list.add(new MainModel(R.drawable.mobile1,"Infinix","50000","Infinix"));
            list.add(new MainModel(R.drawable.mobile2,"Samsung","65000","Samsung"));
            list.add(new MainModel(R.drawable.mobile3,"Iphone","150000","Apple"));
        }
        else if(bundle.getString("name").equals("Glasses")){
            list.add(new MainModel(R.drawable.glasses1,"Rectangle","1000","Wohu Opticals"));
            list.add(new MainModel(R.drawable.glasses2,"Short","1500","Wohu Opticals"));
            list.add(new MainModel(R.drawable.glasses3,"Sunglasses","3000","Wohu Opticals"));
        }
        else if(bundle.getString("name").equals("Shoes")){
            list.add(new MainModel(R.drawable.shoes1,"Joggers","1000","Borjan"));
            list.add(new MainModel(R.drawable.shoes2,"Boots","1500","Borjan"));
            list.add(new MainModel(R.drawable.shoes3,"Heels","3000","Borjan"));
        }
        else if(bundle.getString("name").equals("Bags")){
            list.add(new MainModel(R.drawable.bags1,"Hand Bag","2000","Borjan"));
            list.add(new MainModel(R.drawable.bags2,"Luggage","5000","Borjan"));
            list.add(new MainModel(R.drawable.bags3jpg,"Purse","2000","Borjan"));
        }
        else if(bundle.getString("name").equals("Laptops")){
            list.add(new MainModel(R.drawable.laptop1,"Dell","50,000","i5, 5th gen, 8gb Ram, 500 gb Rom"));
            list.add(new MainModel(R.drawable.laptop2,"Lenovo","75,000","i5, 7th gen, 16gb Ram, 1 TB Rom"));
            list.add(new MainModel(R.drawable.laptop3,"HP","150,000","i9, 1st gen, 16gb Ram, 5 TB Rom"));
        }
        else if(bundle.getString("name").equals("HeadPhones")){
            list.add(new MainModel(R.drawable.laptop1,"Audio-Technica","5,000","Wire"));
            list.add(new MainModel(R.drawable.laptop2,"Sony","7,000","Wireless"));
            list.add(new MainModel(R.drawable.laptop3,"Plantronics","1,000","Wireless"));
        }

        MainAdapter mainAdapter=new MainAdapter(list,this);
        mainPageBinding.MainPageRecyclerView.setAdapter(mainAdapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        mainPageBinding.MainPageRecyclerView.setLayoutManager(linearLayoutManager);

        mainPageBinding.MainPageSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mainAdapter.getFilter().filter(newText.toString());
                return false;
            }
        });
    }
}