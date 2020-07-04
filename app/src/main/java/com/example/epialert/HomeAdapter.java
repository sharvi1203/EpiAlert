package com.example.epialert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends ArrayAdapter<HomeItem> {
    Context context;
    int resource;
    ArrayList<HomeItem> objects;


    public HomeAdapter(Context context, int resource, ArrayList<HomeItem> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(resource,parent,false);
        ImageView image=view.findViewById(R.id.imageViewIcon);
        TextView txtName=view.findViewById(R.id.textViewName);
        TextView txtDesc=view.findViewById(R.id.textViewDesc);
        HomeItem homeItem=objects.get(position);
        image.setBackgroundResource(homeItem.image);
        txtName.setText(homeItem.Name);
        txtDesc.setText(homeItem.Description);
        return view;
    }
}
