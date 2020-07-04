package com.example.epialert;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ActivityTimeLineAdapter extends ArrayAdapter<EpilepsySample> {
    Context context;
    int resource;
    ArrayList<EpilepsySample> objects;
    public ActivityTimeLineAdapter(Context context, int resource, ArrayList<EpilepsySample> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(resource,parent,false);
        TextView txtDate=view.findViewById(R.id.textViewDate);
        TextView txtMonth=view.findViewById(R.id.textViewMonth);
        TextView txtType=view.findViewById(R.id.textViewNameType);
        TextView txtDuration=view.findViewById(R.id.textViewDuration);
        LinearLayout linearLayout=view.findViewById(R.id.linearLayoutTypeAndDur);
        EpilepsySample epilepsySample=objects.get(position);
        int len=epilepsySample.dateMonth.length();
        //Log.i("Date",epilepsySample.dateMonth.substring(len-2,len));
        txtDate.setText(epilepsySample.dateMonth.substring(len-2,len));
        //Log.i("my dates",epilepsySample.dateMonth.substring(0,4));
        String type=epilepsySample.typeOfSeizure;
        if(type.contentEquals("Tonic clonic")){
           linearLayout.setBackgroundResource(R.color.colorPurple);
        }
        if(type.contentEquals("Unknown")){
            linearLayout.setBackgroundResource(R.color.colorBlack);
        }
        if(type.contentEquals("Absence")){
            linearLayout.setBackgroundResource(R.color.colorGreen);
        }
        if(type.contentEquals("Clonic")){
            linearLayout.setBackgroundResource(R.color.colorYellow);
        }
        if(type.contentEquals("Tonic")){
            linearLayout.setBackgroundResource(R.color.colorRed);
        }
        if(type.contentEquals("Focal")){
            linearLayout.setBackgroundResource(R.color.colorPrimary);
        }
        if(type.contentEquals("Atonic")){
            linearLayout.setBackgroundResource(R.color.colorPrimaryDark);
        }
        if(type.contentEquals("Myclonic")){
            linearLayout.setBackgroundResource(R.color.colorAccent);
        }
        txtMonth.setText(epilepsySample.dateMonth.substring(0,4));
        txtType.setText(epilepsySample.typeOfSeizure);
        txtDuration.setText(epilepsySample.startTime+" - "+epilepsySample.endTime);
        return view;
    }
}
