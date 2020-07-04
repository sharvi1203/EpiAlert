package com.example.epialert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;

public class MonthlyCalender extends AppCompatActivity {
    CalendarView calendarView;
    void init(){
        calendarView=findViewById(R.id.calenderSeizure);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_calender);
        init();
    }
}
