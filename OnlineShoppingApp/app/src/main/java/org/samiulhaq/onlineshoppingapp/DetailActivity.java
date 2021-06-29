package org.samiulhaq.onlineshoppingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.samiulhaq.onlineshoppingapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding detailBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailBinding= ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(detailBinding.getRoot());
        final int productImage= getIntent().getIntExtra("productImage",0);
        final int productPrice= Integer.parseInt(getIntent().getStringExtra("productPrice"));
        final String productName= getIntent().getStringExtra("productName");
        final String productDescription= getIntent().getStringExtra("productDesc");

        detailBinding.detailImage.setImageResource(productImage);
        detailBinding.DetailItemName.setText(productName);
        detailBinding.detailPrice.setText(String.format("%d",productPrice));
        detailBinding.detailDescription.setText(productDescription);

        DBHelper dbHelper=new DBHelper(this);
        if(getIntent().getIntExtra("type",1)==1){
            detailBinding.insertButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted=dbHelper.insertOrder(
                            detailBinding.nameBox.getText().toString(),
                            detailBinding.phoneBox.getText().toString(),
                            productPrice,
                            productImage,
                            Integer.parseInt(detailBinding.Quantity.getText().toString()),
                            productDescription,
                            productName
                    );
                    if(isInserted){
                        Toast.makeText(DetailActivity.this,"inserted successfully",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(DetailActivity.this,"failed",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else{
            int orderId= getIntent().getIntExtra("id",0);
            Cursor cursor= dbHelper.getOrderById(orderId);
            int image=cursor.getInt(4);
            detailBinding.detailImage.setImageResource(image);
            detailBinding.detailPrice.setText(String.format("%d",cursor.getInt(3)));
            detailBinding.DetailItemName.setText(cursor.getString(6));
            detailBinding.detailDescription.setText(cursor.getString(5));
            detailBinding.nameBox.setText(cursor.getString(1));
            detailBinding.phoneBox.setText(cursor.getString(2));
            detailBinding.insertButton.setText("Update Now");
            detailBinding.insertButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isUpdated= dbHelper.updateOrder(
                            detailBinding.nameBox.getText().toString(),
                            detailBinding.phoneBox.getText().toString(),
                            Integer.parseInt(detailBinding.detailPrice.getText().toString()),
                            image,
                            Integer.parseInt(detailBinding.Quantity.getText().toString()),
                            detailBinding.detailDescription.getText().toString(),
                            detailBinding.DetailItemName.getText().toString(),
                            orderId
                    );
                    if (isUpdated){
                        Toast.makeText(DetailActivity.this,"Updated",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(DetailActivity.this,"Not Updated",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
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
                startActivity(new Intent(DetailActivity.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    int count=0;
    public void Increment(View view) {
        count++;
        detailBinding.Quantity.setText(""+count);
    }

    public void Decrement(View view) {
        if(count<=1){
            count=1;
        }
        count--;
        detailBinding.Quantity.setText(""+count);
    }
}