package com.example.liqfo.gitprojecttest.Fragments.Git;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.liqfo.gitprojecttest.Objects.Repos;
import com.example.liqfo.gitprojecttest.R;

import java.util.ArrayList;
import java.util.List;

public class ObjectAdapter extends RecyclerView.Adapter<ObjectAdapter.ViewHolder> {

    private List<Repos> dataObjects = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView id;
        public TextView owner;
        public TextView descr;

        public ViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            owner = itemView.findViewById(R.id.owner);
            descr = itemView.findViewById(R.id.desc);
        }
    }

    public ObjectAdapter() {

    }

    public void setDataObjects(List<Repos> dataObjects){
        this.dataObjects = dataObjects;
    }

    public String getUrl(int position){
        return dataObjects.get(position).getHtml_url();
    }

    @Override
    public ObjectAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.id.setText(dataObjects.get(position).getId());
        holder.owner.setText(dataObjects.get(position).getFull_name());
        holder.descr.setText(dataObjects.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return dataObjects.size();
    }
}
