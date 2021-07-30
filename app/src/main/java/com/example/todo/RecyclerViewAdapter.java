package com.example.todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Holder> {
    private ArrayList<ListItems> items =new ArrayList<>();

    public RecyclerViewAdapter(ArrayList<ListItems> items) {
        this.items = items;
    }

    @Override
    public RecyclerViewAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_items,parent,false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.Holder holder, int position) {
        holder.itemView.setTag(items.get(position));
        holder.title.setText(items.get(position).getTitle());
        holder.description.setText(items.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView title,description;
        public Holder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.tvTitle);
            description=itemView.findViewById(R.id.tvDescription);
        }
    }
}
