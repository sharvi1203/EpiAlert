package com.example.epialert;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CurrentStatusAdapter extends ArrayAdapter<CurrentStatusAttributes> {
    Context context;
    int resource;
    ArrayList<CurrentStatusAttributes> objects;
    public CurrentStatusAdapter(Context context, int resource, ArrayList<CurrentStatusAttributes> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(resource,parent,false);
        ImageView image=view.findViewById(R.id.imageViewCurrent);
        TextView units=view.findViewById(R.id.textViewUnits);
        TextView attribute=view.findViewById(R.id.textViewAttributes);
        TextView range=view.findViewById(R.id.textViewRange);
        CurrentStatusAttributes currentStatusAttributes=objects.get(position);
        if(!currentStatusAttributes.range.contentEquals("Normal")){
            range.setTextColor(Color.RED);
        }
        image.setBackgroundResource(currentStatusAttributes.image);
        attribute.setText(currentStatusAttributes.Name);
        if(position==0){
            units.setText("Heart Rate ");
        }
        if(position==1){
            units.setText("EEG frequency ");
        }
        if(position==2){
            units.setText("Body temperature");
        }
        if(position==3){
            units.setText("Oxygen level");
        }
        range.setText(currentStatusAttributes.range);
        return view;
    }
}
