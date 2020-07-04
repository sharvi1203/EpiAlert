package com.example.epialert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CurrentStatus extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    ArrayList<CurrentStatusAttributes> currentStatusAttributes;
    CurrentStatusAdapter adapter;
    void init(){
        listView=findViewById(R.id.listViewCurrent);
        currentStatusAttributes=new ArrayList<>();
        currentStatusAttributes.add(new CurrentStatusAttributes(R.drawable.heartrate,"98 bps","Normal"));
        currentStatusAttributes.add(new CurrentStatusAttributes(R.drawable.eeg,"7 Hz","Low"));
        currentStatusAttributes.add(new CurrentStatusAttributes(R.drawable.bodytemp,"98 F","Normal"));
        currentStatusAttributes.add(new CurrentStatusAttributes(R.drawable.oxygen,"94 %","Low"));
        adapter=new CurrentStatusAdapter(this,R.layout.list_item_current_status,currentStatusAttributes);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_status);
        init();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
