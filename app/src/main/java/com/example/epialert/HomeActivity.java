package com.example.epialert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener{
    ListView listView;
    ArrayList<HomeItem> homeItems;
    HomeAdapter adapter;
    void init(){
        listView=findViewById(R.id.listView);
        HomeItem h1=new HomeItem(R.drawable.current,"Current Status","Current Values");
        HomeItem h4=new HomeItem(R.drawable.activity,"Activity Timeline","Scroll Through your seizure activity");
        HomeItem h2=new HomeItem(R.drawable.month,"Monthly Calender","View your seizure activity by Month");
        HomeItem h3 =new HomeItem(R.drawable.location,"Live Location","Check Live Location of patient and caretaker");
        HomeItem h5=new HomeItem(R.drawable.alarm,"Alarm","Alarm generation on prediction");
        homeItems=new ArrayList<>();
        homeItems.add(h1);
        homeItems.add(h2);
        homeItems.add(h3);
        homeItems.add(h4);
        homeItems.add(h5);
        //homeItems.add(new HomeItem(R.drawable.edit,"Add Seizure","Edit Seizure"))
        adapter=new HomeAdapter(this,R.layout.list_item_home,homeItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        HomeItem homeItem=homeItems.get(i);
        if(i==0){
            Intent intent=new Intent(HomeActivity.this,CurrentStatus.class);
            startActivity(intent);
        }
        if(i==1){
            Intent intent=new Intent(HomeActivity.this,MonthlyCalender.class);
            startActivity(intent);
        }
        if(i==2){
            Intent intent=new Intent(HomeActivity.this,LiveLocation.class);
            startActivity(intent);
        }
        if(i==3){
            Intent intent=new Intent(HomeActivity.this,ActivityTimeline.class);
            startActivity(intent);
        }
        Toast.makeText(this,"You Selected:"+homeItem,Toast.LENGTH_LONG).show();
    }
}
