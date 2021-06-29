package org.samiulhaq.onlineshoppingapp.Adapters;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;


import org.samiulhaq.onlineshoppingapp.DBHelper;
import org.samiulhaq.onlineshoppingapp.DetailActivity;
import org.samiulhaq.onlineshoppingapp.Models.OrderModel;
import org.samiulhaq.onlineshoppingapp.R;

import java.util.ArrayList;
public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.viewHolder>{

    ArrayList<OrderModel> orderList;
    Context context;

    public OrderAdapter(ArrayList<OrderModel> orderList, Context context) {
        this.orderList = orderList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.sample_order,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final OrderModel orderModel=orderList.get(position);
        holder.orderImage.setImageResource(orderModel.getOrderImage());
        holder.soldItemName.setText(orderModel.getSoldItemName());
        holder.orderNumber.setText(orderModel.getOrderNumber());
        holder.orderPrice.setText(orderModel.getOrderPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("id",Integer.parseInt(orderModel.getOrderNumber()));
                intent.putExtra("type",2);
                context.startActivity(intent);

            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Delete Order")
                        .setIcon(R.drawable.ic_baseline_warning_24)
                        .setMessage("Are you sure you want to delete?")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DBHelper dbHelper1=new DBHelper(context);
                                if(dbHelper1.deleteOrder(orderModel.getOrderNumber())>0){
                                    Toast.makeText(context,"Deleted",Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(context,"Not Deleted",Toast.LENGTH_SHORT).show();
                                }

                            }
                        })
                        .setNegativeButton("no", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).show();

                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        ImageView orderImage;
        TextView soldItemName;
        TextView orderPrice;
        TextView orderNumber;

        public viewHolder(@NonNull View itemView){
            super(itemView);
            orderImage= itemView.findViewById(R.id.orderImage);
            soldItemName= itemView.findViewById(R.id.orderItemName);
            orderNumber= itemView.findViewById(R.id.orderNumber);
            orderPrice= itemView.findViewById(R.id.orderPrice);
        }
    }
}