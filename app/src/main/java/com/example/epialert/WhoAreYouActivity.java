package com.example.epialert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WhoAreYouActivity extends AppCompatActivity {
    Button btnPatient,btnCaretaker;
    void init(){
        btnCaretaker=(Button)findViewById(R.id.buttonCaretaker);
        btnPatient=(Button)findViewById(R.id.buttonPatient);
        btnCaretaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(WhoAreYouActivity.this,LoginCaretaker.class);
                startActivity(intent);
            }
        });
        btnPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(WhoAreYouActivity.this,LoginPatient.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who_are_you);
        init();
    }
}
