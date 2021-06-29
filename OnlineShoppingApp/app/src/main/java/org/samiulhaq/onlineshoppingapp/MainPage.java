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
        if(bundle.getString("name").equals("tshirts")){
            list.add(new MainModel(R.drawable.tshirt1,"COTTON V NECK TEE-DARK GREY","1200","US Polo"));
            list.add(new MainModel(R.drawable.tshirt2,"PLAIN COTTON TEE-MUSTARD","1250","US Polo"));
            list.add(new MainModel(R.drawable.tshirt3,"GRAPHIC VEST-BLACK","1000","US Polo"));
            list.add(new MainModel(R.drawable.tshirt4,"ATHLETIC VEST-LIGHT-GREY","950","US Polo"));
        }
        else if(bundle.getString("name").equals("sports")){
            list.add(new MainModel(R.drawable.sports1,"Full Sleeve Shirt","1500","Sunsports"));
            list.add(new MainModel(R.drawable.sports2,"Firefox Activewear Polo","1500","Sunsports"));
            list.add(new MainModel(R.drawable.sports3,"Lahore Qalandars","1170","Sunsports"));
            list.add(new MainModel(R.drawable.sports4,"MEN POLO SHIRT","1500","Sunsports"));
        }
        else if(bundle.getString("name").equals("female dresses")){
            list.add(new MainModel(R.drawable.girls1,"D-GREEN-JACQUARD-SUIT","1000","Bonanza"));
            list.add(new MainModel(R.drawable.girls2,"D-GREEN-JACQUARD-SUIT","7850","Bonanza"));
            list.add(new MainModel(R.drawable.girls3,"D-BEIGE-VISCOSE-SHAWL","3280","Bonanza"));
            list.add(new MainModel(R.drawable.girls4,"PEACH-JAMAWAR-SUIT","14880","Bonanza"));
        }
        else if(bundle.getString("name").equals("sweaters")){
            list.add(new MainModel(R.drawable.sweater1,"Zlittlelazy Red Striped","3245","BTW"));
            list.add(new MainModel(R.drawable.sweater2,"Hanqiu Gray Blue Lining","2751","Borjan"));
            list.add(new MainModel(R.drawable.sweater3,"Navy Grey Contrast Panel","1780","Borjan"));
            list.add(new MainModel(R.drawable.sweater4,"Coodrony Grey","4445","Borjan"));
        }
        else if(bundle.getString("name").equals("mobiles")){
            list.add(new MainModel(R.drawable.mobile1,"Infinix Note 10 Pro","32000","Infinix"));
            list.add(new MainModel(R.drawable.mobile2,"Samsung Galaxy Z Flip","259,999","Samsung"));
            list.add(new MainModel(R.drawable.mobile3,"Vivo Y72 5G","90000","Apple"));
            list.add(new MainModel(R.drawable.mobile4,"iphone 11 Pro MAX","309,999","Apple"));
        }
        else if(bundle.getString("name").equals("glasses")){
            list.add(new MainModel(R.drawable.glasses1,"AVIATORS-BLACK","1150","Wohu Opticals"));
            list.add(new MainModel(R.drawable.glasses2,"HEXA SUNGLASSES-COFFEE","1150","Wohu Opticals"));
            list.add(new MainModel(R.drawable.glasses3,"HEXA SUNGLASSES-COFFEE","1200","Wohu Opticals"));
            list.add(new MainModel(R.drawable.glasses4,"3D RIM SUNGLASSES-BROWN","1150","Wohu Opticals"));
        }
        else if(bundle.getString("name").equals("shoes")){
            list.add(new MainModel(R.drawable.shoes1,"Joggers","3000","Borjan"));
            list.add(new MainModel(R.drawable.shoes2,"Boots","2500","Borjan"));
            list.add(new MainModel(R.drawable.shoes3,"Heels","3000","Borjan"));
            list.add(new MainModel(R.drawable.shoes4,"Joggers","3000","Borjan"));
        }
        else if(bundle.getString("name").equals("bags")){
            list.add(new MainModel(R.drawable.bag1,"EVA TOTE-BLACK","2800","Borjan"));
            list.add(new MainModel(R.drawable.bag2,"FAUX LEATHER BAG-BROWN","3000","Borjan"));
            list.add(new MainModel(R.drawable.bag3,"CASUAL BAG-WHITE","2750","Borjan"));
            list.add(new MainModel(R.drawable.bag4,"CASUAL PURSE-MAROON","2650","Borjan"));
        }
        else if(bundle.getString("name").equals("laptops")){
            list.add(new MainModel(R.drawable.laptop1,"Dell G7 15 7500","299,999","|i7 10750H|16GB|512GB"));
            list.add(new MainModel(R.drawable.laptop2,"Lenovo Ideapad","31,999","2GB RAM - 32GB HDD"));
            list.add(new MainModel(R.drawable.laptop3,"HP PROBOOK","27,300","1.50 Ghz - 4GB RAM - 250GB"));
            list.add(new MainModel(R.drawable.laptop4,"HP Elitebook 840 G3","57,000","i5 6th Generation - 8GB RAM, 128GB SSD"));
        }
        else if(bundle.getString("name").equals("headphones")){
            list.add(new MainModel(R.drawable.headphone1,"Audio-Technica","5,000","Wire"));
            list.add(new MainModel(R.drawable.headphone2,"Sony","7,000","Wireless"));
            list.add(new MainModel(R.drawable.headphone3,"Plantronics","1,000","Wireless"));
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
    @Override
    public boolean onCreateOptionsMenu(Menu cart) {
        getMenuInflater().inflate(R.menu.order_btn,cart);
        return super.onCreateOptionsMenu(cart);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainPage.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}