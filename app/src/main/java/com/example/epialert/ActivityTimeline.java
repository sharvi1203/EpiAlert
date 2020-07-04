package com.example.epialert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.epialert.EpilepsySample;
import com.example.epialert.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class ActivityTimeline extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayList<EpilepsySample> epilepsySamples=new ArrayList<>();
    ListView listView;
    ActivityTimeLineAdapter activityTimeLineAdapter;
    void init(){
        listView=findViewById(R.id.listViewActivityTimeline);
        activityTimeLineAdapter=new ActivityTimeLineAdapter(this,R.layout.list_item_activity,epilepsySamples);
        listView.setAdapter(activityTimeLineAdapter);
        listView.setOnItemClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        readData();
        init();
    }
    void readData(){
        InputStream is=getResources().openRawResource(R.raw.epilepsy);
        BufferedReader reader=new BufferedReader(
          new InputStreamReader(is,Charset.forName("UTF-8"))
        );
        String line="";
        try{
            while((line=reader.readLine())!=null){
             String[] tokens=line.split(",");
             //Log.i("my activity",line);
             tokens[0]=tokens[0].replace('"',' ');
             tokens[2]=tokens[2].replace('"',' ');
             EpilepsySample epilepsySample=new EpilepsySample();
             epilepsySample.day=tokens[0];
             epilepsySample.dateMonth=tokens[1];
             epilepsySample.year=tokens[2];
             epilepsySample.startTime=tokens[3];
             epilepsySample.endTime=tokens[4];
             epilepsySample.duration=tokens[5];
             epilepsySample.bpSys=tokens[6];
             epilepsySample.bpDys=tokens[7];
             epilepsySample.bodyTemp=tokens[8];
             epilepsySample.oxygenLevel=tokens[9];
             epilepsySample.muscleContraction=tokens[10];
             epilepsySample.typeOfSeizure=tokens[11];
             //Log.i("My Activity",tokens[11]+tokens[10]+tokens[9]);
             //epilepsySample.muscleContraction=tokens[11];
             epilepsySamples.add(epilepsySample);
           }
        }catch(Exception e){
            Log.d("My Activity","Error reading data file on line "+line,e);
            e.printStackTrace();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        EpilepsySample epilepsySample=epilepsySamples.get(i);
        Intent intent =new Intent(ActivityTimeline.this,ValuesInTimeline.class);
        //intent.putExtra("keyName","Sharvi");
        intent.putExtra("keyDay",epilepsySample.day);
        intent.putExtra("keyDate",epilepsySample.dateMonth);
        intent.putExtra("keyYear",epilepsySample.year);
        intent.putExtra("keyStartTime",epilepsySample.startTime);
        intent.putExtra("keyEndTime",epilepsySample.endTime);
        intent.putExtra("keyDuration",epilepsySample.duration);
        intent.putExtra("keyBodyTemp",epilepsySample.bodyTemp);
        intent.putExtra("keyHeartRate",epilepsySample.bpSys);
        intent.putExtra("keyMuscle",epilepsySample.muscleContraction);
        intent.putExtra("keyType",epilepsySample.typeOfSeizure);
        intent.putExtra("keyOxygen",epilepsySample.oxygenLevel);
        startActivity(intent);
    }
}
