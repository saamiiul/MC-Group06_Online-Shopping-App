package org.samiulhaq.onlineshoppingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import org.samiulhaq.onlineshoppingapp.Adapters.OrderAdapter;
import org.samiulhaq.onlineshoppingapp.Models.OrderModel;
import org.samiulhaq.onlineshoppingapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding orderBinding;
    DBHelper dbHelper;
    OrderAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orderBinding=ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(orderBinding.getRoot());

        dbHelper=new DBHelper(this);
        ArrayList<OrderModel> list= dbHelper.getOrders();

        adapter=new OrderAdapter(list,this);
        orderBinding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        orderBinding.orderRecyclerView.setLayoutManager(layoutManager);
    }
}