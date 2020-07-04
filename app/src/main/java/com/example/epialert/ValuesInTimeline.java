package com.example.epialert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ValuesInTimeline extends AppCompatActivity {
    TextView txtDate,txtStartTime,txtEndTime,txtDuration,txtHeartRate,txtBodyTemp,txtOxygen,txtMuscle,txtType;
    void init(){
        txtDate=findViewById(R.id.TextViewDateAc);
        txtStartTime=findViewById(R.id.TextViewStartTime);
        txtEndTime=findViewById(R.id.TextViewEndTime);
        txtDuration=findViewById(R.id.textViewDuration);
        txtBodyTemp=findViewById(R.id.TextViewHeartRate);
        txtHeartRate=findViewById(R.id.TextViewHeartRate);
        txtOxygen=findViewById(R.id.TextViewOxygen);
        txtMuscle=findViewById(R.id.TextViewMuscle);
        txtType=findViewById(R.id.TextViewTypeOfSeizure);
        Intent rcv=getIntent();
       // String name=rcv.getStringExtra("keyName");
        String day=rcv.getStringExtra("keyDay");
        String date=rcv.getStringExtra("keyDate");
        String year=rcv.getStringExtra("keyYear");
        String startTime=rcv.getStringExtra("keyStartTime");
        String endTime=rcv.getStringExtra("keyEndTime");
        String duration=rcv.getStringExtra("keyDuration");
        String bodyTemp=rcv.getStringExtra("keyBodyTemp");
        String heartRate=rcv.getStringExtra("keyHeartRate");
        String muscleContraction=rcv.getStringExtra("keyMuscle");
        String typeOfSeizure=rcv.getStringExtra("keyType");
        String oxygenLevel=rcv.getStringExtra("keyOxygen");
         // Log.i("Forward Pass",name);
        txtDate.setText(day+" ,"+date+" ,"+year);
        txtType.setText(typeOfSeizure);
        txtStartTime.setText(startTime);
        txtEndTime.setText(endTime);
        txtDuration.setText(duration);
        txtBodyTemp.setText(bodyTemp);
        txtHeartRate.setText(heartRate);
        txtMuscle.setText(muscleContraction);
        txtOxygen.setText(oxygenLevel);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_values_in_timeline);
        init();
    }
}
