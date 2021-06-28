package org.samiulhaq.onlineshoppingapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import org.samiulhaq.onlineshoppingapp.MainPage;
import org.samiulhaq.onlineshoppingapp.Models.MainItemsModel;
import org.samiulhaq.onlineshoppingapp.R;

import java.util.ArrayList;
import java.util.Collection;

public class MainItemsAdapter extends RecyclerView.Adapter<MainItemsAdapter. viewHolder> implements Filterable {
    ArrayList<MainItemsModel> list = new ArrayList<>();
    ArrayList<MainItemsModel> allItems;
    Context context;

    public MainItemsAdapter(ArrayList<MainItemsModel> list, Context context) {
        this.list = list;
        this.allItems = new ArrayList<>(list);
        this.context = context;
    }

    @NonNull
    @Override
    public MainItemsAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_recycler_sample, parent, false);
        return new MainItemsAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainItemsAdapter.viewHolder holder, int position) {
        final MainItemsModel model = list.get(position);
        holder.imageView.setImageResource(model.getItemImage());
        holder.textView.setText(model.getItemName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, MainPage.class);
                Bundle bundle=new Bundle();
                bundle.putString("name",model.getItemName().toString().toLowerCase());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String searchText = constraint.toString().toLowerCase();
            ArrayList<MainItemsModel> tempList = new ArrayList<>();
            if (searchText.length() == 0 || searchText.isEmpty()) {
                tempList.addAll(allItems);
            } else {
                for (MainItemsModel item : allItems) {
                    if (item.getItemName().toLowerCase().contains(searchText)) {
                        tempList.add(item);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = tempList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            list.clear();
            list.addAll((Collection<? extends MainItemsModel>) results.values);
            notifyDataSetChanged();
        }
    };

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.imageView);
            textView= itemView.findViewById(R.id.textView);
        }
    }
}

